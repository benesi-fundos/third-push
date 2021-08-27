package com.example.medicalsupportsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class patientloggedin extends AppCompatActivity {
    Button visitHospital, plogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientloggedin);
        visitHospital = (Button) findViewById(R.id.visthospt);
          plogOut = (Button) findViewById(R.id.sinout);
          plogOut.setOnClickListener(this:: signout);
        visitHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patientloggedin.this, Appointmants.class);
                startActivity(intent);
            }
        });

    }
    public void signout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), task2.class));
        finish();
    }

}