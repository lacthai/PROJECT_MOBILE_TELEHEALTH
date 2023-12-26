package com.example.android.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edFullName, edAddress, edContact, edPinCode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edFullName = findViewById(R.id.editTextBMBFullName);
        edAddress = findViewById(R.id.editTextBMBAddress);
        edContact = findViewById(R.id.editTextBMBContact);
        edPinCode = findViewById(R.id.editTextBMBPinCode);
        btnBooking = findViewById(R.id.buttonBMBBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        //String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get username using the SharePreferences
                SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                //create the object of database
                Database db = new Database(getApplicationContext(),"healthcare", null, 1);
                db.addOrder(username, edFullName.getText().toString(), edAddress.getText().toString(), edContact.getText().toString(),
                        Integer.parseInt(edPinCode.getText().toString()), date.toString(), "", Float.parseFloat(price[1].toString()), "medicine");
                db.removeCart(username, "medicine");
                Toast.makeText(getApplicationContext(), "Booking Done Successfully!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
            }
        });
    }
}