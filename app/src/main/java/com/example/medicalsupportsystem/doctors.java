package com.example.medicalsupportsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class doctors extends AppCompatActivity {
    Button logout, checkAppts, UploadHealthTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        logout = (Button) (Button)findViewById(R.id.logoutt);
        logout.setOnClickListener(this::logout);
        checkAppts =  (Button) (Button)findViewById(R.id.app);
        UploadHealthTips = (Button) findViewById(R.id.uplodapp);

        checkAppts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctors.this, ShowData.class));
            }
        });

        UploadHealthTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(doctors.this, HeelthTips.class);
                startActivity(intent);

            }
        });
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), register.class));
        finish();
    }

}