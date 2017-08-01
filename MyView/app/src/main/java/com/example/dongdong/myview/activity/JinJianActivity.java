package com.example.dongdong.myview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dongdong.myview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JinJianActivity extends AppCompatActivity {

    @BindView(R.id.mTxt_jinjian_Activity)
    TextView mTxtJinjianActivity;
    @BindView(R.id.toolbars_jinjian_activity)
    Toolbar toolbarsJinjianActivity;
    @BindView(R.id.mEd_tiaojian_jinjian_Activity)
    EditText mEdTiaojianJinjianActivity;
    @BindView(R.id.mEd_shenfenzheng_jinjian_Activity)
    EditText mEdShenfenzhengJinjianActivity;
    @BindView(R.id.mTxt_chaxun_jinjian_Activity)
    TextView mTxtChaxunJinjianActivity;
    @BindView(R.id.mBtn_chaxun_jinjian_Activity)
    Button mBtnChaxunJinjianActivity;
    @BindView(R.id.mTxt_jieguo_jinjian_activity)
    TextView mTxtJieguoJinjianActivity;
    @BindView(R.id.mTxt_xinxi_jinjian_activity)
    TextView mTxtXinxiJinjianActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin_jian);
        ButterKnife.bind(this);

        toolbarsJinjianActivity.setLogo(R.mipmap.zuojiantou);

    }

    @OnClick(R.id.mBtn_chaxun_jinjian_Activity)
    public void onViewClicked() {

    }
}
