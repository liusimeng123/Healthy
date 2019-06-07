package com.suwfe.sm.healthy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FrameActivity extends FragmentActivity {

    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtStep,rbtAlarm,rbtWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mFragments =new Fragment[3];
        fragmentManager =getSupportFragmentManager();
        mFragments[0]=fragmentManager.findFragmentById(R.id.fragment_step);
        mFragments[1]=fragmentManager.findFragmentById(R.id.fragment_alarm);
        mFragments[2]=fragmentManager.findFragmentById(R.id.fragment_water);
        fragmentTransaction =
                fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();

        rbtStep = (RadioButton)findViewById(R.id.radioStep);
        rbtAlarm = (RadioButton)findViewById(R.id.radioAlarm);
        rbtWater = (RadioButton)findViewById(R.id.radioWater);
        rbtStep.setBackgroundResource(R.drawable.shape3);

        radioGroup =(RadioGroup)findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction =
                        fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
                rbtStep.setBackgroundResource(R.drawable.shape2);
                rbtAlarm.setBackgroundResource(R.drawable.shape2);
                rbtWater.setBackgroundResource(R.drawable.shape2);

                switch (checkedId){
                    case R.id.radioStep:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtStep.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioAlarm:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtAlarm.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioWater:
                        fragmentTransaction.show(mFragments[2]).commit();
                        rbtWater.setBackgroundResource(R.drawable.shape3);
                        break;
                    default:
                            break;
                }
            }
        });
    }

}
