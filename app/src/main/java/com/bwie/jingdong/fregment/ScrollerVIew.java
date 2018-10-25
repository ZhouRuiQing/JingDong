package com.bwie.jingdong.fregment;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollerVIew extends ScrollView {
    public ScrollerVIew(Context context) {
        this(context,null,0);
    }

    public ScrollerVIew(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollerVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChanged!=null){
            onScrollChanged.onScrollChanged(l, t, oldl, oldt);
        }
    }
    public interface OnScrollChanged{
        void onScrollChanged(int x, int y, int oldx, int oldy);
    }
    private OnScrollChanged onScrollChanged;

    public void setOnScrollChanged(OnScrollChanged onScrollChanged) {
        this.onScrollChanged = onScrollChanged;
    }
}
