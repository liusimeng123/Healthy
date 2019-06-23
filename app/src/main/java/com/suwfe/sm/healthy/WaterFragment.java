package com.suwfe.sm.healthy;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WaterFragment extends Fragment {
    @Nullable
    String text="";
    Spinner spinner;
    TextView step;
    private  float step2;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frame_water, null);
        step=(TextView) view.findViewById(R.id.step);
        Button PresentLoc = (Button) view.findViewById(R.id.button2); //此处使得Button和xml中的按钮联系
        PresentLoc.setOnClickListener(new LocationCheckedListener()); //这一行是在将button和监听器捆绑


        Resources res =getResources();
        String[] age=res.getStringArray(R.array.age );
        spinner = (Spinner)view.findViewById(R.id.spacer2);//获取到spacer1
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.myspinner,age);//创建Arrayadapter适配器
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text= spinner.getSelectedItem().toString();
            if(text.equals("2~3岁")){
               step.setText("500");
            }else if(text.equals("4~6岁")){
                step.setText("1000");
            }else if(text.equals("6~12岁")){
                step.setText("2000");
            }else if(text.equals("12~18岁")){
                step.setText("4000");
            }else if(text.equals("青壮年成人")){
                step.setText("10000");
            }else {
                step.setText("2000");
            }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return view;
    }

//    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener{
//
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            text= spinner.getSelectedItem().toString();
//            if(text.equals("2~3岁")){
//                step.setText("500");
//            }else if(text.equals("4~6岁")){
//                step.setText("5000");
//            }
//
//
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // TextView tv =(TextView)getView().findViewById(R.id.waterTextView1);
        //tv.setText("water");
    }
   // public void set(View view){
       // Intent hello2 = new Intent(getActivity(), WaterActivity.class);
        //startActivity(hello2);
   // }

    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), MainActivity2.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
            getActivity().startActivity(intent);
            step2=Float.parseFloat(step.getText().toString());
            intent.putExtra("step",step2);
            getActivity().startActivity(intent);
        }

    }



}
