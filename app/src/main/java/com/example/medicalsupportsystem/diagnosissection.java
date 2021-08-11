package com.example.medicalsupportsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class diagnosissection extends AppCompatActivity {
EditText sign1, sign2, sign3, sign4, check;
Button results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosissection);
        sign1 = (EditText) findViewById(R.id.diag2);
        sign2 = (EditText) findViewById(R.id.diag3);
        sign3 = (EditText) findViewById(R.id.diag4);
        sign4 = (EditText) findViewById(R.id.diag5);
        results =(Button) findViewById(R.id.diag6);
        check  = (EditText) findViewById(R.id.diag7);

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sig1, sig2, sig3, sig4;
                sig1 = sign1.getEditableText().toString();
                sig2 = sign2.getEditableText().toString();
                sig3 = sign3.getEditableText().toString();
                sig4 = sign4.getEditableText().toString();
                String chek = check.getEditableText().toString();
                if (sig1.contentEquals("fever") || sig2.contentEquals("sweating") ||
                        sig3.contentEquals("coughing") || sig4.contentEquals("headache")) {
                    check.setText("might be covid19 go for real testing");
                } else if (sig1.contentEquals("sweating") || sig2.contentEquals("fever") ||
                        sig3.contentEquals("headache") || sig4.contentEquals("coughing")) {
                    check.setText("might be covid19 go for real testing");
                } else if (sig1.contentEquals("coughing") || sig2.contentEquals("headache") ||
                        sig3.contentEquals("loss of appetite") || sig4.contentEquals("tiredness")) {
                    check.setText("might be covid19 go for real testing");
                } else if (sig1.contentEquals("loss of appetite") || sig2.contentEquals("tiredness") ||
                        sig3.contentEquals("loss of appetite") || sig4.contentEquals("tiredness")) {
                    check.setText("might be covid19 go for real testing");
                }
                if (sig1.contentEquals("fever") || sig2.contentEquals("Fatigue") ||
                        sig3.contentEquals("headache") || sig4.contentEquals("vomiting")) {
                    check.setText(" can be malaria go for malaria testing");
                }
               else if (sig1.contentEquals("fatigue") || sig2.contentEquals("headache") ||
                        sig3.contentEquals("vomiting") || sig4.contentEquals("muscle pain")) {
                    check.setText(" can be malaria go for malaria testing");
                }
                else if (sig1.contentEquals("muscle pain") || sig2.contentEquals("headache") ||
                        sig3.contentEquals("loss of appetite") || sig4.contentEquals("fatigue")) {
                    check.setText("can be malaria go for malaria testing");
                }
              else if (sig1.contentEquals("loss of appetite") || sig2.contentEquals("muscle pain") ||
                        sig3.contentEquals("fatigue") || sig4.contentEquals("headache")) {
                    check.setText("can be malaria go for malaria testing");
                }
              if (sig1.contentEquals("running nose") || sig2.contentEquals("sore throat") ||
                        sig3.contentEquals("coughing") || sig4.contentEquals("headache")) {
                    check.setText("can be common cold or flu");
                }
              else if (sig1.contentEquals("sore throat") || sig2.contentEquals("running nose") ||
                        sig3.contentEquals("headache") || sig4.contentEquals("running nose")) {
                    check.setText("can be common cold or flu");
                }
              else if (sig1.contentEquals("sore throat") || sig2.contentEquals("coughing") ||
                        sig3.contentEquals("headache") || sig4.contentEquals("running nose")) {
                    check.setText("can be common cold or flu");
                }



            }
            });


        }


    }
