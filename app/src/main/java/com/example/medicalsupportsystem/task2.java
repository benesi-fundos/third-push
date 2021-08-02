package com.example.medicalsupportsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class task2 extends AppCompatActivity {
    Button home, signninn, pSignin;
    EditText pUserName, pUserPassword;
    TextView view;
    DatabaseReference referenci3;
//private firebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        home = (Button) findViewById(R.id.btnb6);
        signninn = (Button) findViewById(R.id.btnb9);
        pSignin = (Button) findViewById(R.id.btnb5);
        pUserName = (EditText) findViewById(R.id.txvs2);
        pUserPassword = (EditText) findViewById(R.id.txvs3);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(task2.this, MainActivity.class);
                startActivity(hom);
            }
        });
        signninn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(task2.this, signuppatient.class);
                startActivity(hom);
            }
        });
        pSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usePassword();
                userName();
                //pSignin(View view);
                isUser();
            }
        });
    }

    public boolean userName() {
        String userName = pUserName.getEditableText().toString();
        if (userName.isEmpty()) {
            pUserName.setError("please fill in your email address");
            pUserName.requestFocus();
            return true;

        } else {
            pUserName.setError(null);
            return false;
        }


    }

    public boolean usePassword() {
        String password = pUserPassword.getEditableText().toString();
        if (password.isEmpty()) {
            pUserPassword.setError("password cannot be empty");
            pUserPassword.requestFocus();
            return false;

        } else {
            pUserPassword.setError(null);
            //pUserPassword.setEnabled(false);
            return true;
        }

    }

    public void pSignin(View view) {
        if (!userName() || !usePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredUserName = pUserName.getEditableText().toString();
        String userEnteredPassword = pUserPassword.getEditableText().toString();
        DatabaseReference referenci3 = FirebaseDatabase.getInstance().getReference("patients");
        Query checkUser = referenci3.orderByChild("pUserName").equalTo(userEnteredUserName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                   // pUserName.setError(null);
                    String passwordFromDB = snapshot.child(userEnteredUserName).child("pUserName").getValue(String.class);
                    if(passwordFromDB.equals(userEnteredPassword)){
                        pUserPassword.setError(null);
                        String nameFromDB = snapshot.child(userEnteredUserName).child("pname").getValue(String.class);
                        String useNameFromDB = snapshot.child(userEnteredUserName).child("pUserName").getValue(String.class);
                        String idNumberFromDB = snapshot.child(userEnteredUserName).child("idnumber").getValue(String.class);
                        Intent intent = new Intent(getApplication(), patientloggedin.class);
                        intent.putExtra("pname",nameFromDB);
                        intent.putExtra("pUserName",useNameFromDB);
                        intent.putExtra("idnumber",idNumberFromDB);
                        startActivity(intent);

                    }
                    else {
                        pUserPassword.setError("wrong password");
                        pUserPassword.requestFocus();
                        return;
                    }
                }
                else {
                    pUserName.setError("no such user exist");
                    pUserName.requestFocus();
                    return;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}