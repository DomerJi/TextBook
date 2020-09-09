package com.textbook.browse.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.text.DecimalFormat;

public class A4Layout extends FrameLayout {

    public A4Layout(Context context) {
        super(context);

    }

    public A4Layout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public A4Layout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private float lv = 297f / 210f;


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        if (width > 0) {
            int height = (int) (width * lv);
            setMeasuredDimension(width, height);
        }
    }

    public static float txfloat(int a, int b) {
        // 设置保留位数
        DecimalFormat df = new DecimalFormat("0.00");
        return Float.valueOf(df.format((float) a * 1f / b));
    }


}
