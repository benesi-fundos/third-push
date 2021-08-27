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
    EditText idNum, fullName, distict1, tradtionAt, village1;
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
        distict1 = (EditText)findViewById(R.id.dist);
        tradtionAt = (EditText)findViewById(R.id.tradA);
        village1 = (EditText)findViewById(R.id.vlg);

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
                String idnum = idNum.getText().toString().trim();
                String name = fullName.getText().toString().trim();
                String distict = distict1.getEditableText().toString();
                String ta = tradtionAt.getEditableText().toString();
                String village = village1.getText().toString().trim();
                String signn1 = psign1.getText().toString().trim();
                String signn2 = psign2.getText().toString().trim();
                String signn3 = psign3.getText().toString().trim();
                String signn4 = psign4.getText().toString().trim();

                rot = FirebaseDatabase.getInstance();
                referenci8 = rot.getReference(  "appointments");
                if(idnum.isEmpty()){
                    idNum.setError("enter id number");
                    idNum.requestFocus();
                    progbarr.setVisibility(View.GONE);
                    return;
                }
                if(name.isEmpty()){
                    fullName.setError("enter name");
                    fullName.requestFocus();
                    progbarr.setVisibility(View.GONE);
                    return;
                }
                if(distict.isEmpty()){
                    distict1.setError("enter district name");
                    distict1.requestFocus();
                    progbarr.setVisibility(View.GONE);
                    return;
                }
                if(ta.isEmpty()){
                    tradtionAt.setError("enter T/A name");
                    tradtionAt.requestFocus();
                    progbarr.setVisibility(View.GONE);
                    return;
                }
                if(village .isEmpty()){
                    village1.setError("enter village name");
                    village1.requestFocus();
                    progbarr.setVisibility(View.GONE);
                    return;
                }
                if(signn1 .isEmpty() && signn2 .isEmpty() && signn3 .isEmpty() && signn4 .isEmpty()){
                    psign1.setError("please enter at least one sign and symptom");
                    psign1.requestFocus();
                    progbarr.setVisibility(View.GONE);
                    return;
                }

                appointments appointments1 = new appointments(idnum,name,distict,ta,village,signn1,signn2,signn3,signn4);
                referenci8.child(idnum).setValue(appointments1);
                referenci8.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(Appointmants.this,"appointment  successfully made you mast wait for approval before physically visiting the hospital ", Toast.LENGTH_LONG).show();
                            progbarr.setVisibility(View.GONE);
                            idNum.setText("");
                            fullName.setText("");
                            distict1.setText("");
                            tradtionAt.setText("");
                            village1.setText("");
                            psign1.setText("");
                            psign2.setText("");
                            psign3.setText("");
                            psign4.setText("");

                            return;
                        }
                        else if(!task.isSuccessful()){
                            progbarr.setVisibility(View.GONE);
                        }
                    }
                });


            }

        });

    }
}