package com.example.venky_suraj_mad_project;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class fetchActivity extends AppCompatActivity {
    EditText e1;
    Spinner tsp;
    TextView txt;
    MedicineData md;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        md=new MedicineData(this);
        e1=findViewById(R.id.editTextDate1);
        tsp=findViewById(R.id.spinner1);
        txt=findViewById(R.id.mtxt);
        b1=findViewById(R.id.Fetchbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=e1.getText().toString();
                String time=tsp.getSelectedItem().toString();
                String med="";
                Cursor cursor=md.FetchActivity(date,time);
                e1.setVisibility(View.INVISIBLE);
                tsp.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                cursor.moveToFirst();
                do {

                    med=med+String.valueOf(cursor.getString(cursor.getColumnIndex("MedName")));
                    med+="\n";
                }
                while (cursor.moveToNext());
                txt.setText(""+med);
            }
        });
    }
}
