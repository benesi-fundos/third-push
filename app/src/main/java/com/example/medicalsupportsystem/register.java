package com.example.medicalsupportsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    FirebaseAuth fAuth;
Button create, prlogin;
EditText prEmail1, prPassword1;
ProgressBar Prgressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        create = (Button) findViewById(R.id.txva8);
        prlogin = (Button) findViewById(R.id.btna);
        prEmail1 = (EditText) findViewById(R.id.etEmail);
        prPassword1 = (EditText) findViewById(R.id.etPsw2);
        fAuth = FirebaseAuth.getInstance();
        Prgressbar= (ProgressBar) findViewById(R.id.progbar);
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
                Prgressbar.setVisibility(View.VISIBLE);
                fAuth = FirebaseAuth.getInstance();
                String email = prEmail1.getText().toString().trim();
                String password = prPassword1.getText().toString().trim();
                if (email.isEmpty()) {
                    prEmail1.setError("fill in email please");
                    prEmail1.requestFocus();
                    Prgressbar.setVisibility(View.GONE);
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
                Prgressbar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Toast.makeText(register.this, "successfully logged in", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), doctors.class));

                            Prgressbar.setVisibility(View.GONE);
                            prEmail1.setText("");
                            prPassword1.setText("");

                        }
                        else {
                            Toast.makeText(register.this, "either email or password is not correct" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            Prgressbar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(), register.class));

                        }
                    }
                });
            }
        });
    }

}