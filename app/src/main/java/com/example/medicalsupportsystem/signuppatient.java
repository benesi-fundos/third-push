 package com.example.medicalsupportsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class signuppatient extends AppCompatActivity {
Button psignin, pregister;
EditText pname, pUserName, ppassword, pcofpassoword, idnumber;
ProgressBar progressbar;
FirebaseDatabase root;
DatabaseReference referenci1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppatient);
      psignin =  (Button)findViewById(R.id.btnc1);
      pregister = (Button)findViewById(R.id.btna1);
      pname = (EditText)findViewById(R.id.ppltx1);
        pUserName= (EditText)findViewById(R.id.ppltx3);
      idnumber = (EditText)findViewById(R.id.pltx1);
      ppassword = (EditText)findViewById(R.id.ppltx4);
      pcofpassoword = (EditText)findViewById(R.id.ppltx5);
      progressbar = (ProgressBar)findViewById(R.id.pbar);

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

                root = FirebaseDatabase.getInstance();
                referenci1 = root.getReference(  "patients");
               String name = pname.getEditableText().toString();
               String userName = pUserName.getEditableText().toString();
               String password = ppassword.getEditableText().toString();
                String idNumber = idnumber.getEditableText().toString();
                patients patients1 = new  patients(name, userName, password, idNumber);
                referenci1.child(idNumber).setValue(patients1);
            }
        });
    }

}