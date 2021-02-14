package com.example.scuba_logbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class AddNewLog extends AppCompatActivity {

    SupportMapFragment mapFragment;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_log);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d("Map", "지도 준비 완료.");
                map = googleMap;
            }
        });

        try{
            MapsInitializer.initialize(this);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 차수 라디오버튼 그룹 Check Listener
        RadioGroup diving_round = (RadioGroup)findViewById(R.id.diving_round);
        diving_round.setOnCheckedChangeListener(radioGroupButtonChangeLister);

    }


    // 달력 관련 코드
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "년 " + month_string + "월 " + day_string + "일");

        Toast.makeText(this,"날짜 선택 완료",Toast.LENGTH_SHORT).show();
        TextView diving_date_select_result = findViewById(R.id.diving_date_select_result);
        diving_date_select_result.setText(dateMessage);
    }

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeLister = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioGroup radioGroup = (RadioGroup)findViewById(R.id.diving_round);
            int RadioId = radioGroup.getCheckedRadioButtonId(); // 체크된 라디오버튼의 ID 리턴
            RadioButton radioButton = (RadioButton)findViewById(RadioId);
            Toast.makeText(AddNewLog.this,radioButton.getText().toString() + " 다이빙 선택 완료",Toast.LENGTH_SHORT).show();
        }
    };



}