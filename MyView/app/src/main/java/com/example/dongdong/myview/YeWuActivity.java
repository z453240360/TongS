package com.example.dongdong.myview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.dongdong.myview.activity.JinJianActivity;
import com.example.dongdong.myview.activity.KeHuActivity;
import com.example.dongdong.myview.fragment.GengDuoFragment;
import com.example.dongdong.myview.fragment.JinJianFragment;
import com.example.dongdong.myview.fragment.KeHuFragment;
import com.example.dongdong.myview.fragment.ShouyeFragment;
import com.example.dongdong.myview.fragment.XiaoXiFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YeWuActivity extends AppCompatActivity {

    @BindView(R.id.mRb_shouye)
    RadioButton mRbShouye;
    @BindView(R.id.mRb_xiaoxi)
    RadioButton mRbXiaoxi;
    @BindView(R.id.mRb_gengduo)
    RadioButton mRbGengduo;
    @BindView(R.id.activity_ye_wu)
    RelativeLayout activityYeWu;
    @BindView(R.id.mRg_main)
    RadioGroup mRgMain;
    @BindView(R.id.mFl_main)
    FrameLayout mFlMain;

    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentManager manager;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ye_wu);
        ButterKnife.bind(this);

        manager = getSupportFragmentManager();

        initFragment();

        manager.beginTransaction().add(R.id.mFl_main, list.get(0)).commit();
        lastFragment = list.get(0);

        init();
    }

    private void init() {
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton select = (RadioButton) findViewById(i);
                int index = Integer.parseInt(select.getTag().toString());

                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    manager.beginTransaction().add(R.id.mFl_main, list.get(index)).commit();
                }

                manager.beginTransaction().hide(lastFragment).commit();
                lastFragment = list.get(index);
            }
        });

    }

    private void initFragment() {
        ShouyeFragment shouyeFragment = new ShouyeFragment();
        XiaoXiFragment xiaoXiFragment = new XiaoXiFragment();
        GengDuoFragment gengDuoFragment = new GengDuoFragment();

        list.add(shouyeFragment);
        list.add(xiaoXiFragment);
        list.add(gengDuoFragment);


        shouyeFragment.setCallBack(new ShouyeFragment.TextCallBack() {
            @Override
            public void getText(String str) {
                if (str.equals("jinjian")){
//                    manager.beginTransaction().replace(R.id.mFl_main,new JinJianFragment()).commit();

                    startActivity(new Intent(YeWuActivity.this, JinJianActivity.class));

                }else if (str.equals("kehu")){
                    startActivity(new Intent(YeWuActivity.this, KeHuActivity.class));
                }
            }
        });




    }
}
