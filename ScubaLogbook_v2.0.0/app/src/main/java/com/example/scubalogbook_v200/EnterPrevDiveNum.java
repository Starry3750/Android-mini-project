package com.example.scubalogbook_v200;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class EnterPrevDiveNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_prev_dive_num);

        Button okBtn = findViewById(R.id.btn_OK);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int diveNum = 0;
                try {
                    TextView prevDiveNumTextView = findViewById(R.id.prev_dive_number);
                    String currentDiveNum = prevDiveNumTextView.getText().toString();
                    if(currentDiveNum == ""){
                        diveNum = 0;
                    }else {
                        diveNum = Integer.parseInt(currentDiveNum.substring(1));    // delete prefix "#"
                    }
                }catch (Exception e){
                    Toast.makeText(EnterPrevDiveNum.this, "Not valid input", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(EnterPrevDiveNum.this, EnterDiveNumAndDate.class);
                intent.putExtra("DiveNumber", diveNum);
                startActivity(intent);
            }
        });

    }

    public void numBtnClickListener(View view){
        TextView prevDiveNumTextView = findViewById(R.id.prev_dive_number);
        String currentDiveNum = prevDiveNumTextView.getText().toString();

        if(currentDiveNum.length() == 5){   // 0 ~ 9999
            currentDiveNum = "";
            prevDiveNumTextView.setText(currentDiveNum);
            return;
        }
        if(currentDiveNum == "")
            currentDiveNum = "#";

        switch (view.getId()){
            case R.id.btn_num0:
                    prevDiveNumTextView.setText(currentDiveNum + "0");
                    break;
            case R.id.btn_num1:
                prevDiveNumTextView.setText(currentDiveNum + "1");
                break;
            case R.id.btn_num2:
                prevDiveNumTextView.setText(currentDiveNum + "2");
                break;
            case R.id.btn_num3:
                prevDiveNumTextView.setText(currentDiveNum + "3");
                break;
            case R.id.btn_num4:
                prevDiveNumTextView.setText(currentDiveNum + "4");
                break;
            case R.id.btn_num5:
                prevDiveNumTextView.setText(currentDiveNum + "5");
                break;
            case R.id.btn_num6:
                prevDiveNumTextView.setText(currentDiveNum + "6");
                break;
            case R.id.btn_num7:
                prevDiveNumTextView.setText(currentDiveNum + "7");
                break;
            case R.id.btn_num8:
                prevDiveNumTextView.setText(currentDiveNum + "8");
                break;
            case R.id.btn_num9:
                prevDiveNumTextView.setText(currentDiveNum + "9");
                break;
            case R.id.btn_Clear:
                prevDiveNumTextView.setText("");
                break;
        }
    }
}