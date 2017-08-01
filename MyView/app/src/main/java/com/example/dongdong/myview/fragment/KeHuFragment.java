package com.example.dongdong.myview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dongdong.myview.R;
import com.example.dongdong.myview.adapter.LikeListAdapter;
import com.example.dongdong.myview.bean.DaiJinJianBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/31.
 */

public class KeHuFragment extends Fragment {


    private RecyclerView mKeHu_rl;
    private ArrayList<String> list = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kehu, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mKeHu_rl = (RecyclerView) view.findViewById(R.id.kehu_rl);
        LikeListAdapter adapter = new LikeListAdapter(getActivity(),list);

        list.add("第一次");

        mKeHu_rl.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        mKeHu_rl.setLayoutManager(manager);

        adapter.setOnItemClickListener(new LikeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                //TODO 获取需要字段请求用户详情
                callBack.getText(list.get(pos));
            }
        });
    }

    public interface TextCallBack{
        void getText(String str);
    }

    private ShouyeFragment.TextCallBack callBack;

    public void setCallBack(ShouyeFragment.TextCallBack callBack){
        this.callBack = callBack;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
