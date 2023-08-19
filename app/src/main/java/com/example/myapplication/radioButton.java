package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

public class radioButton extends AppCompatActivity {

    RadioButton java,C;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        java=(RadioButton) findViewById(R.id.rb1);
        C=(RadioButton)  findViewById(R.id.rb2);

        if(java.isSelected()){
            Toast.makeText(radioButton.this,"Java",Toast.LENGTH_LONG).show();

        }
        else if  (C.isSelected()) {
            Toast.makeText(radioButton.this,"C++",Toast.LENGTH_LONG).show();

        }
    }
}