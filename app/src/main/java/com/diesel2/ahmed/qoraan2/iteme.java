package com.diesel2.ahmed.qoraan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class iteme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteme);

        TextView textView = (TextView) findViewById(R.id.textView);

        Intent items = getIntent();

        final int numitem = items.getExtras().getInt("item") + 1;

        String tx = items.getExtras().getString("in");
        textView.setText(tx);

        ListView itemlist = (ListView) findViewById(R.id.itemList);

        ArrayList Alist = new ArrayList();


        Alist.clear();
        try {

            InputStream input = getAssets().open("item" + numitem + ".txt");
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);


            try {
                String line;

                while ((line = br.readLine()) != null) {
                    Alist.add(line);
                }

            } catch (IOException e) {
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.roo_parts, R.id.parttext, Alist);
        itemlist.setAdapter(arrayAdapter);


        itemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(iteme.this, webv.class);

                intent.putExtra("html", numitem);
                intent.putExtra("item", position);
                startActivity(intent);
            }
        });


    }
}
