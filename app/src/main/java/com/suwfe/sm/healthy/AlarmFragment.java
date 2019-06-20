package com.suwfe.sm.healthy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlarmFragment extends Fragment implements AdapterView.OnItemClickListener {

    private String TAG = AlarmFragment.class.getName();
    private ListView list ;
    private ArrayAdapter adapter;

    /**
     * @描述 在onCreateView中加载布局
     * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_alarm, container,false);
        list = (ListView) view.findViewById(android.R.id.list);
        Log.i(TAG, "--------onCreateView");
        initListView();
        return view;
    }


    public void initListView() {
        Log.i(TAG, "--------onCreate");
        List<String> retList =new ArrayList<String>();
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String todayString = sdf.format(today);



        Log.i("run","日期相等，从数据库中获取数据");
        StepManager dbManager = new StepManager(getActivity());
        for (StepItem rateItem : dbManager.listAll()) {
            if (!todayString.equals(rateItem.getCurName())) {
                retList.add(rateItem.getCurName() + "=>" + rateItem.getCurRate());
                Log.i(TAG, "List list  " + rateItem.getCurName() + "=>" + rateItem.getCurRate());

            }
        }
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,retList);
        list.setAdapter(adapter);

    }


    private List<? extends Map<String, ?>> getData(String[] strs) {
        List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();

        for (int i = 0; i < strs.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title", strs[i]);
            list.add(map);

        }

        return list;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "--------onActivityCreated");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "----------onAttach");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {





    }
}