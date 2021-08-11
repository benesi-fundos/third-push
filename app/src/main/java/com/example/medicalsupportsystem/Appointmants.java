package com.example.medicalsupportsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Appointmants extends AppCompatActivity {
    EditText idNum, fullName, distict, tradtionAt, village;
    EditText psign1, psign2, psign3, psign4;
    Button submit;
    ProgressBar progbarr;
    FirebaseDatabase rot;
    DatabaseReference referenci8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmants);
        idNum = (EditText)findViewById(R.id.data);
        fullName = (EditText)findViewById(R.id.fname);
        distict = (EditText)findViewById(R.id.dist);
        tradtionAt = (EditText)findViewById(R.id.tradA);
        village = (EditText)findViewById(R.id.vlg);

        psign1 = (EditText)findViewById(R.id.sign1);
        psign2 = (EditText)findViewById(R.id.sign2);
        psign3 = (EditText)findViewById(R.id.sign3);
        psign4 = (EditText)findViewById(R.id.sign4);
        submit = (Button)findViewById(R.id.dbtn1);
        progbarr = (ProgressBar)findViewById(R.id.proggresbar);
       progbarr.setVisibility(View.INVISIBLE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progbarr.setVisibility(View.VISIBLE);
                String idNumm = idNum.getText().toString().trim();
                String name = fullName.getText().toString().trim();
                String distictt  = distict.getEditableText().toString();
                String ta = tradtionAt.getEditableText().toString();
                String vlage = village.getText().toString().trim();
                String signn1 = psign1.getText().toString().trim();
                String signn2 = psign2.getText().toString().trim();
                String signn3 = psign3.getText().toString().trim();
                String signn4 = psign4.getText().toString().trim();

                rot = FirebaseDatabase.getInstance();
                referenci8 = rot.getReference(  "appointments");
                appointments appointments1 = new appointments(idNumm,name,distictt,ta,vlage,signn1,signn2,signn3,signn4);
                referenci8.child(idNumm).setValue(appointments1);
                referenci8.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Appointmants.this,"your appointment is successiful ", Toast.LENGTH_LONG).show();
                            //psign4.setText("succsess");
                            progbarr.setVisibility(View.GONE);
                            return;
                        }
                    }
                });


            }

        });

    }
}