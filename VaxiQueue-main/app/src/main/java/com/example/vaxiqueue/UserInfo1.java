package com.example.vaxiqueue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Arrays;

import static android.widget.AdapterView.*;

public class UserInfo1 extends AppCompatActivity implements OnItemSelectedListener {
    float diab = 0;
    float htension = 0;
    float immunonum = 0;
    float resp = 0;
    float kidneynum = 0;
    float preg = 0;
    float ratio = 0;
    float indpop = 1387345526;
    float a1=0;
    int pop=0;
    float l1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info1);

        Spinner spinner = findViewById(R.id.spinner_1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String location = parent.getItemAtPosition(position).toString();
       if (location.equals("Mumbai")){
            pop = 12442373;
        }
        if (location.equals("Delhi")){
            pop = 11007835;
        }
        if (location.equals("Bangalore")){
            pop = 8436675;
        }
        if (location.equals("Hyderabad")){
            pop = 6809970;
        }
        if (location.equals("Ahmedabad")){
            pop = 5570585;
        }
        if (location.equals("Chennai")){
            pop = 4681087;
        }
        if (location.equals("Kolkata")){
            pop = 4486679;
        }
        if (location.equals("Surat")){
            pop = 4467797;
        }
        if (location.equals("Pune")){
            pop = 3115431;
        }
        if (location.equals("Jaipur")){
            pop = 3046163;
        }
        if (location.equals("Others")){
            pop = 976000;
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void diabetes(View view){
        if (diab == 4){
            diab = 0;
        }
        if (diab == 0){
            diab = 4;
        }
    }

    public void hypertension(View view){
        if (htension == 4){
            htension = 0;
        }
        if (htension == 0){
            htension = 4;
        }
    }

    public void immunos(View view){
        if (immunonum == 3){
            immunonum = 0;
        }
        if (immunonum == 0){
            immunonum = 3;
        }
    }

    public void respiratory(View view){
        if (resp == 4){
            resp = 0;
        }
        if (resp == 0){
            resp = 4;
        }
    }

    public void kidney(View view){
        if (kidneynum == 2){
            kidneynum = 0;
        }
        if (kidneynum == 0){
            kidneynum = 2;
        }
    }

    public void pregnancy(View view){
        if (preg == 4){
            preg = 0;
        }
        if (preg == 0){
            preg = 4;
        }
    }
    public void test(View view){
        Bundle bundle = getIntent().getExtras();
        float passvalue = bundle.getFloat("summation");
        ratio = diab + htension +immunonum+ resp + kidneynum + preg;
        a1 = a1 + ((float)(ratio/17))*((float)5/24);
        a1 = a1+(float)(pop/13000000)*(float)(1/24);
        l1 = a1*(indpop);
        float finalvalue= passvalue-l1;

        LottieAnimationView test = (LottieAnimationView) findViewById(R.id.textView11);
        Intent NextIntent = new Intent(this,FinalPage.class);
        NextIntent.putExtra("final", finalvalue);
        startActivity(NextIntent);
    }

}