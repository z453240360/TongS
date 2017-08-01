package com.example.dongdong.myview.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.dongdong.myview.R;
import com.example.dongdong.myview.fragment.KeHuFragment;
import com.example.dongdong.myview.fragment.ShouyeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeHuActivity extends AppCompatActivity {


    @BindView(R.id.mRb_shouye_kehu)
    RadioButton mRbShouyeKehu;
    @BindView(R.id.mRb_xiaoxi_kehu)
    RadioButton mRbXiaoxiKehu;
    @BindView(R.id.mRb_gengduo_kehu)
    RadioButton mRbGengduoKehu;
    @BindView(R.id.mRg_kehu)
    RadioGroup mRgKehu;
    @BindView(R.id.mFl_kehu)
    FrameLayout mFlKehu;
    @BindView(R.id.activity_ke_hu)
    RelativeLayout activityKeHu;
    @BindView(R.id.searchView)
    SearchView searchView;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ke_hu);

        ButterKnife.bind(this);
        searchView.setQueryHint("搜索");

        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.mFl_kehu, new KeHuFragment()).commit();
        KeHuFragment keHuFragment = new KeHuFragment();

        keHuFragment.setCallBack(new ShouyeFragment.TextCallBack() {
            @Override
            public void getText(String str) {
                manager.beginTransaction().add(R.id.mFl_kehu, new KeHuFragment()).commit();
            }
        });
    }

    @OnClick({R.id.mRb_shouye_kehu, R.id.mRb_xiaoxi_kehu, R.id.mRb_gengduo_kehu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mRb_shouye_kehu:
                manager.beginTransaction().add(R.id.mFl_kehu, new KeHuFragment()).commit();
                break;
            case R.id.mRb_xiaoxi_kehu:
                break;
            case R.id.mRb_gengduo_kehu:
                break;
        }
    }
}
