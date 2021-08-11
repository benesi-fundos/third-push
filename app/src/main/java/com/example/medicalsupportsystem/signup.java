package com.example.medicalsupportsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
Button signupp, PrRegister;
FirebaseAuth fAuth;
EditText prName, PrIdNumber, PrEmail, prPassword, prcofpassword;
FirebaseDatabase root;
ProgressBar pgresibar;
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
        pgresibar = (ProgressBar)findViewById(R.id.prgesbar);
        fAuth = FirebaseAuth.getInstance();

        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signnupp = new Intent(signup.this, register.class);
                startActivity(signnupp);
            }
        });
      //if(fAuth.getCurrentUser() != null){
          //startActivity(new Intent(getApplicationContext(), register.class));
          //finish();
      //}

        PrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root = FirebaseDatabase.getInstance();
                referenci2 = root.getReference(  "professionals");
                String name = prName.getEditableText().toString();
                String email = PrEmail.getText().toString().trim();
                String password = prPassword.getText().toString().trim();
                String idNumber = PrIdNumber.getEditableText().toString();
                String confirmPassword = prcofpassword.getEditableText().toString();
                mAuth = FirebaseAuth.getInstance();


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

                pgresibar.setVisibility(View.VISIBLE);


                professional professional1 = new professional(name, idNumber, email, password);
                referenci2.child(idNumber).setValue(professional1);



            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(signup.this, "user registration is completed you can now sign in", Toast.LENGTH_LONG).show();
                      startActivity(new Intent(getApplicationContext(), register.class));
                      pgresibar.setVisibility(View.GONE);
                  }

                  else {
                      Toast.makeText(signup.this, "error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                  }
                 }

             });

            }
        });
    }


    }

