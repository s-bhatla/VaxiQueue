package com.example.vaxiqueue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;;

public class splash_screen extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.imageView);

        logo.animate().translationY(2100).setDuration(1000).setStartDelay(1800);

        final Intent i = new Intent(this,MainActivity.class);
        Thread timer  = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();



    }
}