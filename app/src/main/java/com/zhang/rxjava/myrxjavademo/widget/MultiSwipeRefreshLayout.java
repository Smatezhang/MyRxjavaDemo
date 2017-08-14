package com.zhang.rxjava.myrxjavademo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.zhang.rxjava.myrxjavademo.R;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class MultiSwipeRefreshLayout extends SwipeRefreshLayout {


    private Drawable drawable;
    private CanChildScrollUpCallback mcanChildScrollUpCallback;

    public MultiSwipeRefreshLayout(Context context) {
        super(context);
    }

    public MultiSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MultiSwipeRefreshLayout, 0, 0);
        drawable = array.getDrawable(R.styleable.MultiSwipeRefreshLayout_foreground);
        if (drawable == null){
            drawable.setCallback(this);
            setWillNotDraw(false);
        }
        array.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (drawable != null) {
            drawable.setBounds(0, 0, w, h);
        }

    }

    public void setCanChildScrollUpCallback(CanChildScrollUpCallback canChildScrollUpCallback){
        mcanChildScrollUpCallback = canChildScrollUpCallback;
    }

       //定义接口
    public interface CanChildScrollUpCallback {

        boolean canSwipeRefreshChildScrollUp();
    }

    @Override
    public boolean canChildScrollUp() {

        if (mcanChildScrollUpCallback != null){
            return  mcanChildScrollUpCallback.canSwipeRefreshChildScrollUp();
        }
        return super.canChildScrollUp();
    }
}
