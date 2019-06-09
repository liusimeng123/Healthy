package com.suwfe.sm.healthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Water2Activity extends AppCompatActivity {

    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water2);

        Intent intent = getIntent();
        float water_total_amount= intent.getFloatExtra("water_total_amount",800.0f);
        float cup_capacity = intent.getFloatExtra("cup_capacity",250.0f);
        float reslut =water_total_amount/cup_capacity;

        result = (EditText)findViewById(R.id.EditText);
        result.setText(String.valueOf(reslut));
    }
}
