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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Atorvastatin", "", "", "", "40"},
                    {"Amlodipine", "", "", "", "60"},
                    {"Metformin", "", "", "", "100"},
                    {"Gabapentin (Neurontin)", "", "", "", "60"},
                    {"Omeprazole (Prilosec)", "", "", "", "70"},
                    {"Levothyroxine", "", "", "", "85"},
                    {"Lisinopril", "", "", "", "65"},
                    {"Adalimumab", "", "", "", "45"},
                    {"Acrivastine", "", "", "", "95"},
            };

    private String[] package_details = {
                    "Atorvastatin is a medication that belongs to the class of drugs known as statins. It is commonly prescribed to lower levels of low-density lipoprotein cholesterol (LDL-C), also known as \"bad\" cholesterol, in the blood",
                    "Amlodipine is a medication that belongs to the class of drugs called calcium channel blockers. It is commonly used to treat high blood pressure (hypertension) and certain types of chest pain (angina)\n" +
                            "As with any medication, Amlodipine can have potential side effects. Common side effects may include dizziness, swelling in the ankles or feet, flushing, headache, or stomach pain.",
                    "Metformin is an oral medication that belongs to the biguanide class of drugs. It is primarily used for the treatment of type 2 diabetes mellitus, particularly in overweight and obese individuals\n" +
                            "The main purpose of Metformin is to help lower blood sugar levels in people with type 2 diabetes.\n" +
                            "By controlling blood sugar levels, Metformin can help prevent complications associated with diabetes such as kidney damage, nerve problems, and blindness\n" +
                            "It's important to note that Metformin should be taken under the guidance and prescription of a healthcare professional.",
                    "Gabapentin, commonly known by its brand name Neurontin, is a medication that belongs to the class of anticonvulsant drugs. It is primarily used to treat seizures associated with epilepsy and also helps in managing nerve pain caused by conditions such as shingles\n" +
                            "Gabapentin works by decreasing abnormal excitement in the brain, which helps control seizures and reduce nerve-related pain \n" +
                            "As with any medication, Gabapentin may cause side effects. Common side effects include drowsiness, dizziness, fatigue, coordination problems, and gastrointestinal discomfort. However, not everyone experiences these side effects, and they are usually temporary",
                    "Omeprazole, commonly known by its brand name Prilosec, is a medication used to treat various conditions related to the stomach and esophagus. It is primarily prescribed for the treatment of gastric and duodenal ulcers, erosive esophagitis, and gastroesophageal reflux disease (GERD)",
                    "Levothyroxine is a medication used to treat hypothyroidism, which is an underactive thyroid gland. The thyroid gland produces insufficient amounts of thyroid hormone, and levothyroxine helps to replace or provide more of this hormone ",
                    "Lisinopril is a medication commonly used to treat high blood pressure, also known as hypertension. By lowering high blood pressure, lisinopril helps to reduce the risk of strokes, heart attacks, and kidney problems",
                    "Adalimumab, also known by the brand name Humira, is a medication classified as a monoclonal antibody. It is used to treat various inflammatory conditions such as rheumatoid arthritis, psoriatic arthritis, ankylosing spondylitis, Crohn's disease, ulcerative colitis, and plaque psoriasis",
                    "Acrivastine is a medication used for the treatment of allergies and hay fever. It belongs to the class of second-generation H1-receptor antagonist antihistamines. It is known for its non-sedating properties, meaning it is less likely to cause drowsiness compared to some other antihistamines.\n" +
                            "Acrivastine works by blocking the action of histamine, a substance in the body that causes allergic reactions. By inhibiting histamine, acrivastine helps alleviate symptoms such as sneezing, itching, runny nose, and watery eyes associated with allergies and hay fever.",
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        //create the object of list
        list = new ArrayList();
        for (int i=0; i<packages.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5","Fees:"+packages[i][4]+"$");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2","line3", "line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}