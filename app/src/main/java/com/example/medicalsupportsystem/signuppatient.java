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

 public class signuppatient extends AppCompatActivity {
Button psignin, pregister;
EditText pname, pemail, ppassword, pcofpassoword, idnumber;
ProgressBar progressbar;
FirebaseAuth mAuth;
FirebaseDatabase root;
DatabaseReference referenci1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppatient);
      psignin =  (Button)findViewById(R.id.btnc1);
      pregister = (Button)findViewById(R.id.btna1);
      pname = (EditText)findViewById(R.id.ppltx1);
        pemail= (EditText)findViewById(R.id.ppltx3);
      idnumber = (EditText)findViewById(R.id.pltx1);
      ppassword = (EditText)findViewById(R.id.ppltx4);
      pcofpassoword = (EditText)findViewById(R.id.ppltx5);
      progressbar = (ProgressBar)findViewById(R.id.pbar);
        mAuth = FirebaseAuth.getInstance();

      psignin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent psignin =  new Intent(signuppatient.this, task2.class);
              startActivity(psignin);
          }
      });
        pregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar.setVisibility(View.VISIBLE);
                root = FirebaseDatabase.getInstance();
                referenci1 = root.getReference(  "patients");
               String name = pname.getEditableText().toString();
               String email = pemail.getEditableText().toString();
               String password = ppassword.getEditableText().toString();
                String idNumber = idnumber.getEditableText().toString();
                patients patients1 = new  patients(name, email, password, idNumber);
                referenci1.child(idNumber).setValue(patients1);
               // String emaill = pemail.getText().toString().trim();
                //String passwordd =ppassword.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                 Toast.makeText(signuppatient.this, "user registration is completed you can now sign in", Toast.LENGTH_LONG).show();
                 startActivity(new Intent(getApplicationContext(), task2.class));
                    progressbar.setVisibility(View.GONE);
                 }
                }
                });


            }
        });
    }

}