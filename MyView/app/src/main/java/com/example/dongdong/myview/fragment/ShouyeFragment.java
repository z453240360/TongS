package com.example.dongdong.myview.fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dongdong.myview.R;
import com.example.dongdong.myview.activity.KeHuActivity;
import com.example.dongdong.myview.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.R.id.list;

/**
 * Created by dongdong on 2017/7/30.
 */

public class ShouyeFragment extends Fragment {

    @BindView(R.id.mBtn_jinjian)
    Button mBtnJinjian;
    @BindView(R.id.mBtn_kehu)
    Button mBtnKehu;
    @BindView(R.id.mBtn_qiangdan)
    Button mBtnQiangdan;
    @BindView(R.id.mBtn_shenpi)
    Button mBtnShenpi;
    @BindView(R.id.mBtn_shisuan)
    Button mBtnShisuan;
    @BindView(R.id.mBtn_yeji)
    Button mBtnYeji;
    @BindView(R.id.mBtn_longhu)
    Button mBtnLonghu;
    @BindView(R.id.mBtn_gonggao)
    Button mBtnGonggao;
    @BindView(R.id.mBtn_chanpin)
    Button mBtnChanpin;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        List<Image> list = new ArrayList<>();

        ButterKnife.bind(getActivity());
        Banner banner = (Banner) view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(list);
        banner.start();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mBtn_jinjian, R.id.mBtn_kehu, R.id.mBtn_qiangdan, R.id.mBtn_shenpi, R.id.mBtn_shisuan, R.id.mBtn_yeji, R.id.mBtn_longhu, R.id.mBtn_gonggao, R.id.mBtn_chanpin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_jinjian:
                callBack.getText("jinjian");
                break;
            case R.id.mBtn_kehu:
                callBack.getText("kehu");
                break;
            case R.id.mBtn_qiangdan:
                callBack.getText("qiangdan");
                break;
            case R.id.mBtn_shenpi:
                callBack.getText("shenpi");
                break;
            case R.id.mBtn_shisuan:
                callBack.getText("shisuan");
                break;
            case R.id.mBtn_yeji:
                callBack.getText("yeji");
                break;
            case R.id.mBtn_longhu:
                callBack.getText("longhu");
                break;
            case R.id.mBtn_gonggao:
                callBack.getText("gonggao");
                break;
            case R.id.mBtn_chanpin:
                callBack.getText("chanpin");
                break;
        }
    }

    public interface TextCallBack{
        void getText(String str);
    }

    private TextCallBack callBack;

    public void setCallBack(TextCallBack callBack){
        this.callBack = callBack;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
