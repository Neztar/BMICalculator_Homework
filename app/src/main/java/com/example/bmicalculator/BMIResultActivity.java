package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMIResultActivity extends AppCompatActivity {

    TextView showtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("bmi_value",0);
        String bmiText = intent.getStringExtra("bmi_text");

        showtext = (TextView)findViewById(R.id.showBmi_text);
        String result = String.format("ค่า BMI ที่ได้คือ %.2f\n\nอยู่ในเกณฑ์ %s",bmi,bmiText);
        showtext.setText(result);
    }
}
