package com.example.vaxiqueue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class UserMainInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    float job_num = 0;
    String job;
    String name;
    float age;
    String sex;
    float indpop = 1387345526;
    float a1;
    float passvalue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_info);
        Spinner spinner = findViewById(R.id.spinner_2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.jobs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setPrompt("");


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        job = parent.getItemAtPosition(position).toString();
        if (job.equals("Health-Care Worker")){
            job_num = 1;
        }

        if (job.equals("Public Safety Worker")){
            job_num = (float) 0.75;
        }

        if (job.equals("Retail Employee")){
            job_num = (float) 0.5;
        }

        if (job.equals("Others")){
            job_num = (float) 0.25;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void getSex_male(View view){
        sex = "Male";
    }


    public void getSex_female(View view){
        sex = "Female";
    }
    public void getPosition(View view){
        TextView NameIn = (TextView) findViewById(R.id.editTextPersonName);
        name = "" + NameIn.getText();

        TextView ageIn = (TextView) findViewById(R.id.editTextage);
        age = Integer.parseInt(ageIn.getText().toString());

        if(age < 16){
            age = 120 - age;
        }

        a1 = (job_num)*((float)10/24);





        a1 = a1 + ((float)8/24)*(age/120);


        passvalue = (1-a1)*indpop;


        if (sex.equals("Male")){
            Intent NextIntent = new Intent(UserMainInfo.this,UserInfoMale.class);
            NextIntent.putExtra("summation", passvalue);
            startActivity(NextIntent);
        }
        if (sex.equals("Female")){
            Intent NextIntent = new Intent(UserMainInfo.this,UserInfo1.class);
            NextIntent.putExtra("summation", passvalue);
            startActivity(NextIntent);
        }

    }
}