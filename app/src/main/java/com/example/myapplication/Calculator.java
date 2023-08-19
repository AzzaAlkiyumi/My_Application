package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    float x,y,z;

    String scrtext ,sign,signed ,result;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textView =findViewById(R.id.text0);
        signed="0";
        scrtext="";
        result="0";

    }

    public  void onClicknumbers(View view) {
        result="0";
         if(signed.equals("0")){
             Button button=(Button) view;
             scrtext +=button.getText().toString();
             textView.setText(scrtext);
             x=Float.parseFloat(scrtext);
         }else {
             Button button=(Button)view;
             scrtext+=button.getText().toString();
             textView.setText(scrtext);
             y=Float.parseFloat(scrtext);
         }
    }

    public void onClickSign(View view) {
        Button button=(Button)view;
        sign=button.getText().toString();
        textView.setText(sign);
        signed="1";
        scrtext="0";
    }

    public void onClickResult(View view) {
        Button button=(Button)view;
        if(sign.equals("+")){
            z=x+y;
        } else if (sign.equals("-")) {
            z=x-y;

        } else if (sign.equals("*")) {
            z=x*y;

        } else if (sign.equals("/")) {
            z=x/y;

        }
        result=Float.toString(z);
        textView.setText(result);
        scrtext="0";
        signed="0";
    }
    public void onClickClear(View view) {
        Button button=(Button) view;
        sign="0";
        signed="0";
       result="0";
        textView.setText("0");

    }
}
