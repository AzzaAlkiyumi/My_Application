package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Rigistration extends AppCompatActivity {
    //  EditText user1,email1 ,password1,Cpassword1;
     Button Rigbtn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigistration);
        EditText  user = findViewById(R.id.userName);
        EditText    email=findViewById(R.id.email);
        EditText   password=findViewById(R.id.password);
        EditText   Cpassword=findViewById(R.id.confirmPass);
         Button     Rigbtn=findViewById(R.id.btnRigst);

        Rigbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().isEmpty() || user.getText().toString().length()<7){
                  user.setError("user name is not correct! name should be not empty");
                }

                else if (!email.getText().toString().matches(emailPattern))
                //(email.getText().toString().isEmpty() || !email.getText().toString().contains("@") )
                {
                    email.setError("email not correct!");
                }
                else if (password.getText().toString().isEmpty() || password.getText().toString().length()<8 ) {
                    password.setError("Password should be grater than 7 characters");
                } else if (!Cpassword.getText().toString().matches(password.getText().toString())) {

                    Cpassword.setError("Passwords dont match!");
                }
                  else {
                      Toast.makeText(Rigistration.this, "Register successful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

