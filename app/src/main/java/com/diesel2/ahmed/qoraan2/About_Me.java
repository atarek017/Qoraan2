package com.diesel2.ahmed.qoraan2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class About_Me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__me);
    }

    public void gmacont(View view) {
        try {

            String txt=" السلام عليكم ورحمة الله وبركاته ";
            Intent sendemail=new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("messag/rfc822");

            sendemail.putExtra(Intent.EXTRA_EMAIL,"atarek017@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT,"Quraan");
            sendemail.putExtra(Intent.EXTRA_TEXT,txt);

            startActivity(sendemail);

        }catch (Exception e){
            Toast.makeText(this,"عذرا لا يوجد تطيق بريد",Toast.LENGTH_LONG).show();
        }



    }
}
