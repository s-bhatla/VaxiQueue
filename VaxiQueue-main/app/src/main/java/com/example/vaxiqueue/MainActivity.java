package com.example.vaxiqueue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    LottieAnimationView lottieAnimationView2;
    TextView main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.lottieAnimationView);

    }



    public void open_infoview(View view){
        Intent intent = new Intent(this,information_page.class);
        startActivity(intent);

    }
}











     /* I did isAnimated boolean to handle second time click. Also
       try pauseAnimation, cancelAnimation and another else. I can't success it anyways. */

