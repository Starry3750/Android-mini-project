package com.example.scubalogbook_v200;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class EnterDiveNumAndDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_dive_num_and_date);

        Intent intent = new Intent(this.getIntent());
        int temp  = intent.getIntExtra("DiveNumber", 0);
        Toast.makeText(EnterDiveNumAndDate.this, String.valueOf(temp), Toast.LENGTH_SHORT).show();
    }
}