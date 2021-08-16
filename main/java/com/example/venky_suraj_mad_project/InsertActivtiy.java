package com.example.venky_suraj_mad_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class InsertActivtiy extends AppCompatActivity {
    EditText e1,e2;
    Spinner tsp;
    Button b1;
    MedicineData md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_activtiy);
        md= new MedicineData(this);
        e1=findViewById(R.id.editTextMname);
        e2=findViewById(R.id.editTextDate);
        tsp=findViewById(R.id.spinner);
        b1=findViewById(R.id.Insertbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String date=e2.getText().toString();
                String time=tsp.getSelectedItem().toString();
                boolean insert=md.insertValues(name,date,time);
                if (insert==true)
                {
                    Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_LONG).show();
                            e1.setText(null);
                    e2.setText(null);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"data not inserted",Toast.LENGTH_LONG).show(); }
                }
            });
        }
    }
