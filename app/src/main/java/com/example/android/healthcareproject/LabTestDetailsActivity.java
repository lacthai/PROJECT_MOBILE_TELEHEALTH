package com.example.android.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnBack, btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextLDTextMultiLine);
        btnAddToCart = findViewById(R.id.buttonLDAddToCart);
        btnBack = findViewById(R.id.buttonLDBack);

        edDetails.setKeyListener(null); //not able to edit the text

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: " + intent.getStringExtra("text3") +"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("share_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                //create database object
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if (db.checkCart(username,product) ==1){
                    Toast.makeText(getApplicationContext(), "This Product Have Already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Add To Cart Complete!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });


    }
}