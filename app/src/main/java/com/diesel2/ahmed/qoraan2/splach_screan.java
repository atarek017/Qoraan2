package com.diesel2.ahmed.qoraan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splach_screan extends AppCompatActivity {

    ImageView img;
    Animation anm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screan);


        Thread thread=new Thread(){
            public void run(){

                try {
                    sleep(6500);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();


        img=(ImageView)findViewById(R.id.imageView5);
        anm= AnimationUtils.loadAnimation(this,R.anim.anime);

        img.setAnimation(anm);
    }
}
