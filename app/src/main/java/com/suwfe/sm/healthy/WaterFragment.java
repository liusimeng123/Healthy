package com.suwfe.sm.healthy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WaterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.activity_main2, container);


//        View view = inflater.inflate(R.layout.frame_water, null);
//        //在fragment视图中的按钮
//        Button btn2 = (Button)view.findViewById(R.id.button2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //在这里使用getActivity
//                Intent intent = new Intent(getActivity(),MainActivity2.class);
//                startActivity(intent);
//            }
//        });
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.frame_water, null);
        Button PresentLoc = (Button) view.findViewById(R.id.button2); //此处使得Button和xml中的按钮联系
        PresentLoc.setOnClickListener(new LocationCheckedListener()); //这一行是在将button和监听器捆绑
        return view;
    }

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
        }

    }
}
