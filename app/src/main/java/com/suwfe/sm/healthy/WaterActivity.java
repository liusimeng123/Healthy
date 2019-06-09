package com.suwfe.sm.healthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class WaterActivity extends AppCompatActivity {

    private float water_total_amount = 800.0f;
    private float cup_capacity = 250.0f;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
    }
    public void openOne(View btn){
        Intent config = new Intent(this,Water2Activity.class);
        config.putExtra("water_total_amount",water_total_amount);
        config.putExtra("cup_capacity",cup_capacity);
        //startActivity(config);
        startActivityForResult(config,1);
    }
}
