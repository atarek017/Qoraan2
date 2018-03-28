package com.diesel2.ahmed.qoraan2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listPart;
  TextView textpart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPart=(ListView)findViewById(R.id.partlist);
        textpart=(TextView)findViewById(R.id.parttext);

        String[] part=getResources().getStringArray(R.array.parts);

        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.roo_parts,R.id.parttext,part);
        listPart.setAdapter(arrayAdapter);



        listPart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent=new Intent(MainActivity.this,iteme.class);
                intent.putExtra("item",position);
                intent.putExtra( "in", (String) parent.getItemAtPosition(position));

                startActivity(intent);
            }
        });

    }






    public void img_share(View view) {

        String txtShare="قران كريم";
        String sharelink="https://drive.google.com/file/d/oBxVaspY8fuamcU5LT3ZrMEMtbTQ/view";

        Intent share =new Intent(Intent.ACTION_SEND);

        share.setType("text/plain");

        share.putExtra(Intent.EXTRA_TEXT,txtShare + "\n"+sharelink);
        startActivity(share);
    }


    public void img_more(View view) {

        Toast.makeText(this," About Me",Toast.LENGTH_SHORT).show();



    Intent abo=new Intent(this,About_Me.class);


        startActivity(abo);



    }

    public void img_maile(View view) {

        try {

            Toast.makeText(this,"Send your problem",Toast.LENGTH_SHORT).show();

            String txt=" السلام عليكم ورحمة الله وبركاته ";

            Intent sendemail=new Intent(Intent.ACTION_SEND);

            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("messag/rfc822");

            sendemail.putExtra(Intent.EXTRA_EMAIL,"atarek017@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT,"Quraan");
            sendemail.putExtra(Intent.EXTRA_TEXT,txt);

            Intent choser=Intent.createChooser(sendemail,"send email");
            startActivity(choser);

        }catch (Exception e){
            Toast.makeText(this,"عذرا لا يوجد تطيق بريد",Toast.LENGTH_LONG).show();
        }



    }

    public void img_close(View view) {

        Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show();
        finish();
    }




}
