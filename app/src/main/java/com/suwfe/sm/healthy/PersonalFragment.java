package com.suwfe.sm.healthy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonalFragment extends Fragment {
    private final String TAG = "PersonalFragment";
    private float weight_water_Rate = 40.0f;

    EditText weight;
    TextView show;
    TextView question1;
    TextView question2;
    private  float weight2;
    String str;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.frame_personal, null);
        question1 = view.findViewById(R.id.personalTextView1);
        weight = view.findViewById(R.id.personalEditView1);
        question2 = view.findViewById(R.id.personalTextView2);
        show = view.findViewById(R.id.personalTextView3);


        Button PresentLoc = (Button) view.findViewById(R.id.button); //此处使得Button和xml中的按钮联系
        PresentLoc.setOnClickListener(new PersonalFragment.LocationCheckedListener()); //这一行是在将button和监听器捆绑


        //weight2 = sharedPreferences.getFloat("weight2_rate",40.0f);

        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>0){
                    float r = Float.parseFloat(s.toString());
                    show.setText(String.valueOf(r*weight_water_Rate));
                }else{
                    Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
                }
            }
        });
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if((weight.getText().toString()).equals("")){
                Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CountActivity.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                weight2=Float.parseFloat(weight.getText().toString());
                intent.putExtra("weight",weight2);
                getActivity().startActivityForResult(intent,1);

            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1 && resultCode==2){

            Bundle bundle = data.getExtras();
            weight2 = bundle.getFloat("key_dollar",40.0f);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
