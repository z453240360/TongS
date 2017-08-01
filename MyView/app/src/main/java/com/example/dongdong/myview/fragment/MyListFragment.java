package com.example.dongdong.myview.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by samsung on 2017/1/4.
 */

public class MyListFragment extends ListFragment {


    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private String s;

    public static MyListFragment getInstance(String s) {
        MyListFragment mlf = new MyListFragment();
        Bundle args = new Bundle();
        args.putString("str",s);
        mlf.setArguments(args);
        return mlf;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();

        initAdatper();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initAdatper() {
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
        setListAdapter(adapter);
    }

    private void initData() {
        s = getArguments().getString("str");
        for (int i = 0; i < 20; i++) {
            list.add(s+i);
        }

    }
}
