package com.example.scuba_logbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button move_to_add_log_btn = findViewById(R.id.new_log);
        move_to_add_log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewLog.class);
                startActivity(intent);
            }
        });


    }

    // 카페 이동 버튼 클릭
    public void gocafeButtonClicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/skybluechmhh"));
        startActivity(intent);
    }

    //퐁당닷컴 이동 버튼 클릭
    public void gopongdangButtonClicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pongdang.com/"));
        startActivity(intent);
    }

    // 해경전화 버튼 클릭
    public void call_coast_guard(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-5936-3877"));
        startActivity(myIntent);
    }

    // 119 버튼 클릭
    public void call_119(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-5936-3877"));
        startActivity(myIntent);
    }

    // 팀장전화 버튼 클릭
    public void call_team_leader(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-5936-3877"));
        startActivity(myIntent);
    }



}