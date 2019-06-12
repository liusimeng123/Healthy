package com.suwfe.sm.healthy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalFragment extends Fragment {
    private final String TAG = "PersonalFragment";
    private float weight_water_Rate = 40.0f;

    EditText weight;
    TextView show;
    TextView question1;
    TextView question2;
    float weight2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.frame_personal, null);
        question1 = view.findViewById(R.id.personalTextView1);
        weight = view.findViewById(R.id.personalEditView1);
        question2 = view.findViewById(R.id.personalTextView2);
        show = view.findViewById(R.id.personalTextView3);



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
        Button button = (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "nihao", Toast.LENGTH_LONG).show();
            }
        });
    }
}
