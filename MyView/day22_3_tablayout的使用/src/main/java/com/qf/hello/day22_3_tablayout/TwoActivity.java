package com.qf.hello.day22_3_tablayout;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {

    /*
    实现TabLayout与ViewPager的配合使用
     */
    private TabLayout layout;

    private ViewPager pager;

    private ArrayList<Fragment> list = new ArrayList<>();
    private MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        initView();

        initPagerData();

        initPagerAdapter();
        layout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //设置TabLayout中选中的Tab标签下方线条的颜色
        layout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        //设置TabLayout中选中的Tab标签下方线条的高度
        layout.setSelectedTabIndicatorHeight(0);

        /**
         * 参数1： 非选中时的文字颜色
         * 参数2：选中时的文字颜色
         */
        layout.setTabTextColors(Color.BLACK,Color.BLUE);

        //注意：此方法一定要在ViewPager设置了适配器之后调用
        layout.setupWithViewPager(pager);

        //如果一定需要让标签上显示图标或者显示自定义的内容时
        for (int i = 0; i < layout.getTabCount(); i++) {
            TabLayout.Tab tab = layout.getTabAt(i);
//            tab.setIcon(R.drawable.ic_menu);
            View vi = LayoutInflater.from(this).inflate(R.layout.custom,null);
            //设置自定义显示内容
            tab.setCustomView(vi);
            ((TextView)vi.findViewById(R.id.textView)).setText("电影"+i);
        }


    }

    private void initTab() {


        for (int i = 0; i < 15; i++) {
            layout.addTab(layout.newTab().setText("标签"+i));
        }
    }

    private void initPagerAdapter() {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }

    private void initPagerData() {
        for (int i = 0; i < 15; i++) {
            list.add(MyListFragment.getInstance("标签"+i));
        }
    }

    private void initView() {

        layout = (TabLayout)findViewById(R.id.tablayout);
        pager = (ViewPager)findViewById(R.id.pager);

    }
    
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //一旦通过setUpWithViewPager方法设置TabLayout与ViewPager的配合显示后
        //通过此方法控制标签上文本的显示
        @Override
        public CharSequence getPageTitle(int position) {
            return "标签"+position;
        }
    }
}
