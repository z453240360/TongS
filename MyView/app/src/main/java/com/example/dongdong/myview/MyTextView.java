package com.example.dongdong.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by dongdong on 2017/7/30.
 */

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Context context) {

    }
}
