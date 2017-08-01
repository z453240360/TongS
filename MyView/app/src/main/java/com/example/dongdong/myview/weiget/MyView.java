package com.example.dongdong.myview.weiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.dongdong.myview.R;

/**
 * Created by dongdong on 2017/7/29.
 */

public class MyView extends RelativeLayout {

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init(Context context)
    {
//        View view = LayoutInflater.from(context).inflate(R.layout.itemas, this, true);
        initContentView(context);
    }

    private void initContentView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemas, null);
        addView(view);
    }


}

