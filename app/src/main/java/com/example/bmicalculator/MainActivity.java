package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity{

    private EditText heightedit,weightedit;
    private Button calbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightedit = (EditText) findViewById(R.id.editText_height);
        weightedit = (EditText) findViewById(R.id.editText_weight);
        calbutton = (Button) findViewById(R.id.button_calculate);

        calbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.valueOf(heightedit.getText().toString());
                final Double weight = Double.valueOf(weightedit.getText().toString());
                //BMI = weight(kg)/height^2(m)
                height /= 100;
                double bmi = weight/(height*height);
                String bmiText = getBmi(bmi);
                //String result = String.format("ค่า BMI ที่ได้คือ %.2f\n\nอยู่ในเกณฑ์ %s",bmi,bmiText);
                Intent intent = new Intent(MainActivity.this,BMIResultActivity.class);

                intent.putExtra("bmi_value",bmi);
                intent.putExtra("bmi_text",bmiText);
                startActivity(intent);
            }
            private String getBmi(double bmi) {
                //BMI = weight(kg)/height^2(m)
                // bmi < 18.5 : น้ำหนักน้อยกว่าปกติ
                // bmi < 25 : น้ำหนักปกติ
                // bmi < 30 : น้ำหนักมากกว่าปกติ(ท้วม)
                // bmi >=30 : น้ำหนักมากกว่าปกติมาก(อ้วน)
                String bmiText="";
                if(bmi< 18.5){bmiText="น้ำหนักน้อยกว่าปกติ";}
                else if(bmi<25){bmiText="น้ำหนักปกติ";}
                else if(bmi<30){bmiText="น้ำหนักมากกว่าปกติ(ท้วม)";}
                else{bmiText="น้ำหนักมากกว่าปกติมาก(อ้วน)";}
                return bmiText;
    }
        });
    }//End onCreate
}//End MainActivity
