package com.example.android.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindHospitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hospital);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(FindHospitalActivity.this, HomeActivity.class)
                );
            }
        });
        CardView hospital1 = findViewById(R.id.cardHospital1);
        hospital1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindHospitalActivity.this, HospitalDetailsActivity.class);
                it.putExtra("title", "HCM CITY'S TOP HOSPITALS"); //set the HCM HOSPITAL as a title key name
                startActivity(it);
            }
        });

        CardView hospital2 = findViewById(R.id.cardHospital2);
        hospital2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindHospitalActivity.this, HospitalDetailsActivity.class);
                it.putExtra("title", "HA NOI CITY'S TOP HOSPITALS");
                startActivity(it);
            }
        });

        CardView hospital3 = findViewById(R.id.cardHospital3);
        hospital3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindHospitalActivity.this, HospitalDetailsActivity.class);
                it.putExtra("title", "DA NANG CITY'S HOSPITALS");
                startActivity(it);
            }
        });

        CardView hospital4 = findViewById(R.id.cardHospital4);
        hospital4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindHospitalActivity.this, HospitalDetailsActivity.class);
                it.putExtra("title", "HUE CITY'S HOSPITALS");
                startActivity(it);
            }
        });

        CardView hospital5 = findViewById(R.id.cardHospital5);
        hospital5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindHospitalActivity.this, HospitalDetailsActivity.class);
                it.putExtra("title", "DA LAT CITY'S HOSPITALS");
                startActivity(it);
            }
        });
    }
}