package com.example.medicalsupportsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
public Button signup1, signin1,  signup2, signin2, goForTest, visitHospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
signup1 =(Button)findViewById(R.id.btn1);
signin1 =(Button)findViewById(R.id.btn2);
signup2 =(Button)findViewById(R.id.btnb1);
signin2=(Button)findViewById(R.id.btnb2);
goForTest=(Button)findViewById(R.id.btn3);
visitHospital = (Button)findViewById(R.id.visthosp);

        signup1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
  Intent create = new Intent(MainActivity.this, signup.class);
  startActivity(create);
    }
});
signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(MainActivity.this, signuppatient.class);
                startActivity(create);
            }
        });
signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create1 = new Intent(MainActivity.this, register.class);
                startActivity(create1);
            }
        });
signin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create1 = new Intent(MainActivity.this, task2.class);
                startActivity(create1);
            }
        });
goForTest.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, diagnosissection.class);
        startActivity(intent);
    }
});
visitHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Appointmants.class);
                startActivity(intent);
            }
        });


    }
}