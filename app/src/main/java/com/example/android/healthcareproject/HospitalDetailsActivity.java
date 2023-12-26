package com.example.android.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HospitalDetailsActivity extends AppCompatActivity {
    private String[][] hospital_details1 = {
            {"Hospital Name: Nhi Dong 1 Hospital", "Hospital Address: Vietnam", "Rate: 4.53", "Mobile No:028 3927 1119","700"},
            {"Hospital Name: Nhi Dong 2 Hospital", "Hospital Address: Vietnam", "Rate: 4.21", "Mobile No:028 3829 5723","580"},
            {"Hospital Name: Y Duoc Hospital", "Hospital Address: Vietnam", "Rate: 4.8", "Mobile No:028 3855 4269","650"},
            {"Hospital Name: Hung Vuong Hospital", "Hospital Address: Vietnam", "Rate: 4.5", "Mobile No:028 3856 2310", "750"},
            {"Hospital Name: Tu Du Hospital", "Hospital Address:Vietnam ", "Rate: 4.6", "Mobile No:028 5404 2829","660"},
            {"Hospital Name: Nhan Dan 115 Hospital", "Hospital Address: Vietnam ", "Rate: 4.59", "Mobile No:1900 099983 ","900"},
            {"Hospital Name: Nhan Dan Gia Dinh Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:028 3841 2692 ", "500"}
    };

    private String[][] hospital_details2 = {
            {"Hospital Name: Phuong Dong Hospital", "Hospital Address: No. 9, Vien Ward, Co Nhue, Bac Tu Liem, Hanoi ", "Rate: 4.5", "Mobile No:1900 1806","800"},
            {"Hospital Name: Bach Mai Hospital", "Hospital Address: No. 78 Giai Phong Street, Phuong Mai Ward, Dong Da District, Hanoi, Vietnam ", "Rate: 4.5", "Mobile No:1900 888 866","600"},
            {"Hospital Name: Da Khoa Quoc te Vinmec Times City Hospital", "Hospital Address: 458 Minh Khai Street, Hai Ba Trung District, Hanoi", "Rate: 4.8", "Mobile No:0899.648.761","500"},
            {"Hospital Name: Da khoa Hong Ngoc Hospital", "Hospital Address: No. 8 Chau Van Liem, District, Nam Tu Liem, Hanoi ", "Rate: 4.8", "Mobile No:0274 3688 686","900"},
            {"Hospital Name: Da Khoa Phuong Dong Hospital", "Hospital Address: No. 9 Pho Vien, Co Nhue 2, Bac Tu Liem District, Hanoi ", "Rate: 4.8", "Mobile No:1900 1806","700"},
            {"Hospital Name: Da Khoa Quoc Te Thu Cuc Hospital", "Hospital Address: 286 Thuy Khue, Tay Ho District, Hanoi ", "Rate: 4.4", "Mobile No:093.638.288","650"}
    };

    private String[][] hospital_details3 = {
            {"Hospital Name: Da Nang Hospital", "Hospital Address: 124 Hai Phong, Thach Thang, Hai Chau Da Nang ", "Rate: 4.8", "Mobile No:0236.3821118","600"},
            {"Hospital Name: Hoan My Hospital", "Hospital Address: 291 (old number 161) Nguyen Van Linh - Thanh Khe - Da Nang ", "Rate: 4.9", "Mobile No:05113650676","700"},
            {"Hospital Name: Gia Dinh Hospital", "Hospital Address: 73 Nguyen Huu Tho, Hai Chau, Da Nang ", "Rate: 4.2", "Mobile No:1900 2250","650"},
            {"Hospital Name: Y Hoc Co Truyen Hospital", "Hospital Address: 342 Phan Chau Trinh, Da Nang ", "Rate: 4.6", "Mobile No:0905 658 333","800"},
            {"Hospital Name: Phu San - Nhi Hospital", "Hospital Address: 402 Le Van Hien, Khue My, Ngu Hanh Son, Da Nang ", "Rate: 4.5", "Mobile No:0236 3957 777","600"}
    };

    private String[][] hospital_details4 = {
            {"Hospital Name: Trung Uong Hospital", "Hospital Address: 16 Le Loi, Vinh Ninh, City. Hue, Thua Thien Hue ", "Rate: 4.8", "Mobile No:023 4382 2325","800"},
            {"Hospital Name: Y Duoc Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","540"},
            {"Hospital Name: Eyes Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","680"},
            {"Hospital Name: Tam Than Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","900"},
            {"Hospital Name: GTVT Hospital", "Hospital Address: Vietnam ", "Rate: 4.8", "Mobile No:9898989898","560"}
    };


    private String[][] hospital_details5 = {
            {"Hospital Name: Hoan My Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","780"},
            {"Hospital Name: Lam Dong II Hospital", "Hospital Address: Vietnam ", "Rate: 4.8", "Mobile No:9898989898","900"},
            {"Hospital Name: Y Hoc Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","400"},
            {"Hospital Name: Bao Lam Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","540"},
            {"Hospital Name: Recover Hospital", "Hospital Address: Vietnam ", "Rate: 4.5", "Mobile No:9898989898","560"}
    };
    TextView tv;
    Button btn;
    String[][] hospital_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        btn = findViewById(R.id.buttonLDBack);

        tv = findViewById(R.id.textViewHosDetailTitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title"); //get key name "title"
        tv.setText(title); //set that title to the title text view

        if(title.compareTo("HCM CITY'S TOP HOSPITALS") == 0){
            hospital_details = hospital_details1;
        }

        if(title.compareTo("HA NOI CITY'S TOP HOSPITALS") == 0){
            hospital_details = hospital_details2;
        }

        if(title.compareTo("DA NANG CITY'S HOSPITALS") == 0){
            hospital_details = hospital_details3;
        }

        if(title.compareTo("HUE CITY'S HOSPITALS") == 0){
            hospital_details = hospital_details4;
        }

        if(title.compareTo("DA LAT CITY'S HOSPITALS") == 0){
            hospital_details = hospital_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HospitalDetailsActivity.this, FindHospitalActivity.class));
            }
        });
        btn.setVisibility(View.VISIBLE);

        list = new ArrayList();
        for (int i=0; i<hospital_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", hospital_details[i][0]);
            item.put("line2", hospital_details[i][1]);
            item.put("line3", hospital_details[i][2]);
            item.put("line4", hospital_details[i][3]);
            item.put("line5","Fees:"+hospital_details[i][4]+"$");
            list.add(item);
            sa = new SimpleAdapter(this, list,
                    R.layout.multi_lines,
                    new String[]{"line1", "line2","line3", "line4","line5"},
                    new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                    );
            ListView lst = findViewById(R.id.listViewOD);
            lst.setAdapter(sa);

            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it = new Intent(HospitalDetailsActivity.this, BookAppointmentActivity.class);
                    it.putExtra("text1", title);
                    it.putExtra("text2", hospital_details[i][0]);
                    it.putExtra("text3", hospital_details[i][1]);
                    it.putExtra("text4", hospital_details[i][3]);
                    it.putExtra("text5", hospital_details[i][4]);
                    startActivity(it);
                }
            });
        }
    }
}