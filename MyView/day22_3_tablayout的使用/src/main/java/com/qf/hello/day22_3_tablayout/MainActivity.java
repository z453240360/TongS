package com.qf.hello.day22_3_tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout layout;

    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (TabLayout) findViewById(R.id.tablayout);
        /*
        设置标签模式
        可选：
        TabLayout.MODE_FIXED (默认)
        TabLayout.MODE_SCROLLABLE  (相对高大上效果)
        当标签个数比较多时，使用此模式，提供横向滚动能力
         */
        layout.setTabMode(TabLayout.MODE_FIXED);
        /*
        当TabMode设置的是FiXED模式时，可以通过setTabGravity方法控制
        标签时居中显示还是平分屏幕宽度
        TabLayout.GRAVITY_FILL  平分屏幕宽度
        TabLayout.GRAVITY_CENTER  居中显示（默认）
         */
        layout.setTabGravity(TabLayout.GRAVITY_FILL);

        //向TabLayout添加指定个数的标签
        initTab();

        getSupportFragmentManager().beginTransaction().add(R.id.frame,list.get(0)).commit();
        //设置TabLayout的监听事件
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //当标签被选中时调用的方法
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index = Integer.parseInt(tab.getTag().toString());
                if (!list.get(index).isAdded()) {
                    getSupportFragmentManager().beginTransaction().add(R.id.frame,list.get(index)).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(list.get(index)).commit();
                }

            }
            //当标签被取消选中时调用的方法
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int index = Integer.parseInt(tab.getTag().toString());
                getSupportFragmentManager().beginTransaction().hide(list.get(index)).commit();
            }
            //当标签被重复选中时调用的方法
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTab() {

        for (int i = 0; i < 4; i++) {
            layout.addTab(layout.newTab().setIcon(R.mipmap.ic_launcher).setText("电影"+i).setTag(i));

            //向集合中添加Fragment对象

            list.add(MyListFragment.getInstance("电影"+i+"  "));

        }
//        layout.addTab(layout.newTab().setIcon(R.mipmap.ic_launcher).setText("电影"));
//        layout.addTab(layout.newTab().setIcon(R.mipmap.ic_launcher).setText("电视剧"));
//        layout.addTab(layout.newTab().setIcon(R.mipmap.ic_launcher).setText("综艺"));
    }
}
