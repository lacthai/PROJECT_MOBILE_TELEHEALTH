package com.example.android.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package 1: Basic Health Checkup","","","","100"},
                    {"Package 2: Maternity Care","","","","1500"},
                    {"Package 3: Cardiac Health Package","","","","300"},
                    {"Package 4: Dental Care Package","","","","150"},
                    {"Package 5: Orthopedic Wellness","","","","250"},
                    {"Package 6: Executive Health Screening ","","","","500"}
            };
    private String[] packages_details = {
            "Physical Examination\n" +
            "Blood Pressure Measurement\n" +
            "Complete Blood Count (CBC)\n"+
            "Urinalysis\n"+
            "Basic Lipid Profile\n"+
            "Doctor's Consultation\n",

            "Obstetrician Consultations (Antenatal and Postnatal)\n"+
            "Ultrasound Scans\n"+
            "Blood Type and Rh Factor Testing\n"+
            "Routine Blood Tests (Hemoglobin, Glucose)\n"+
            "Delivery Room Charges\n"+
            "Pediatrician Consultation for Newborn\n",

            "Electrocardiogram (ECG or EKG)\n"+
            "Stress Test\n"+
            "Lipid Profile\n"+
            "Chest X-ray\n"+
            "Cardiologist Consultation\n"+
            "Blood Pressure Monitoring\n",

            "Dental Cleaning and Scaling\n"+
            "X-rays (Bitewing)\n"+
            "Oral Examination\n"+
            "Fluoride Treatment\n"+
            "Basic Cavity Filling (up to 2 teeth)\n"+
            "Dentist Consultation\n",

            "Orthopedic Consultation\n"+
            "X-rays (Joint-specific)\n"+
            "Bone Density Test (DEXA Scan)\n"+
            "Physical Therapy Session\n"+
            "Joint Mobility Assessment\n"+
            "Doctor's Follow-up Consultation\n",

            "Full Body Checkup\n"+
            "Comprehensive Blood Panel\n"+
            "Cancer Marker Screening\n"+
            "Abdominal Ultrasound\n"+
            "Vision and Hearing Tests\n"+
            "Nutritionist Consultation\n",
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonLDAddToCart);
        btnBack = findViewById(R.id.buttonLDBack);
        listView = findViewById(R.id.listViewOD);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: " + packages[i][4]+"/-");
            list.add(item); //add item into list object
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                );
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                //pass the data into lab details activity
                it.putExtra("text1", packages[i][0]); //package name
                it.putExtra("text2", packages_details[i]); //package details
                it.putExtra("text3", packages[i][4]); //package cost
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }
}