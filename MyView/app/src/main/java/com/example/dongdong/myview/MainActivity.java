package com.example.dongdong.myview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mob.commons.SMSSDK;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.log_main)
    ImageView logMain;
    @BindView(R.id.mEd_user_phoneNumber)
    EditText mEdUserPhoneNumber;
    @BindView(R.id.mEd_user_password)
    EditText mEdUserPassword;
    @BindView(R.id.mBtn_getPassword)
    Button mBtnGetPassword;
    @BindView(R.id.mBtn_logIn)
    Button mBtnLogIn;


    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        toolbar = (Toolbar) findViewById(R.id.toolbars);
//        toolbar.setLogo(R.mipmap.zuojiantou);

    }

    @OnClick({R.id.mBtn_getPassword, R.id.mBtn_logIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_getPassword:

                break;
            case R.id.mBtn_logIn:
                startActivity(new Intent(MainActivity.this, YeWuActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
