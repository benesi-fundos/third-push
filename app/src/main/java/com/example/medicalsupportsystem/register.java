package com.example.medicalsupportsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private FirebaseAuth mAuth;
Button create, prlogin;
EditText prEmail1, prPassword1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        create = (Button) findViewById(R.id.txva8);
        prlogin = (Button) findViewById(R.id.btna);
        prEmail1 = (EditText) findViewById(R.id.etEmail);
        prPassword1 = (EditText) findViewById(R.id.etPsw2);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(register.this, signup.class);
                startActivity(create);
            }
        });
        prlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                String email = prEmail1.getEditableText().toString();
                String password = prPassword1.getEditableText().toString();
                if (email.isEmpty()) {
                    prEmail1.setError("fill in email please");
                    prEmail1.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    prEmail1.setError("please provide a valid email address");
                    prEmail1.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    prPassword1.setError("fill in password please");
                    prPassword1.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    prPassword1.setError("password must be greater than 6 characters long ");
                    prPassword1.requestFocus();
                    return;
                }
                 mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                //professional professional = new professional(email, password);
                 }
                }

                 });
            }
        });
    }

}