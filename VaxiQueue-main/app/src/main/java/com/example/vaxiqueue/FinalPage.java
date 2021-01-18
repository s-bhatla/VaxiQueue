package com.example.vaxiqueue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class FinalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        Bundle bundle = getIntent().getExtras();
        float finalvalue = bundle.getFloat("final");
        TextView textView = (TextView)findViewById(R.id.textView8);
        DecimalFormat df = new DecimalFormat("#,###.00");
        //textView.setText(String.format("%.0f", finalvalue));
        textView.setText(df.format(finalvalue));
    }
}