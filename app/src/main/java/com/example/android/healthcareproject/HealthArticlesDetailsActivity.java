package com.example.android.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetailsActivity extends AppCompatActivity {

    TextView tv;
    ImageView img;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);

        tv = findViewById(R.id.textViewHADTitle);
        img = findViewById(R.id.imageViewHAD);
        btnBack = findViewById(R.id.buttonHADBack);

        // get the data from that intent
        Intent intent = getIntent();
        // set the title to tv
        tv.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesDetailsActivity.this, HealthArticlesActivity.class));
            }
        });
    }
}