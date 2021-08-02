package com.example.medicalsupportsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
Button signupp, PrRegister;
EditText prName, PrIdNumber, PrEmail, prPassword, prcofpassword;
FirebaseDatabase root;
DatabaseReference referenci2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
       signupp = (Button)findViewById(R.id.btnb7);
        prName = (EditText)findViewById(R.id.ppltx1);
        PrIdNumber = (EditText)findViewById(R.id.ppltx2);
        PrEmail = (EditText)findViewById(R.id.ppltx3);
        prPassword = (EditText)findViewById(R.id.ppltx4);
        PrRegister = (Button)findViewById(R.id.btna1);
        prcofpassword = (EditText)findViewById(R.id.ppltx5);


        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signnupp = new Intent(signup.this, register.class);
                startActivity(signnupp);
            }
        });

        PrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root = FirebaseDatabase.getInstance();
                referenci2 = root.getReference(  "professionals");
                String name = prName.getEditableText().toString();
                String email = PrEmail.getEditableText().toString();
                String password = prPassword.getEditableText().toString();
                String idNumber = PrIdNumber.getEditableText().toString();
                String confirmPassword = prcofpassword.getEditableText().toString();


                if(TextUtils.isEmpty(email)){
                    PrEmail.setError("please fill in email address");
                    PrEmail.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    PrEmail.setError("please fill in your name");
                    PrEmail.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(idNumber)){
                    PrIdNumber.setError("please fill in professional  identity number ");
                    PrIdNumber.requestFocus();
                    return;
                }
                if(password.length() != confirmPassword.length()){
                    prcofpassword.setError("passwordss not matching");
                    prcofpassword.requestFocus();
                     return;
                }




                professional professional1 = new professional(name, idNumber, email, password);
                referenci2.child(idNumber).setValue(professional1);
            }
        });
    }


    }

