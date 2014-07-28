package com.brunocapezzali.androiduiactionsheet;

import android.view.View;

/**
 * Created by Bruno Capezzali on 14/07/2014.
 *
 */
public abstract class BaseWidget {

    protected int mTag;
    protected int mResourceViewId;
    protected View mView = null;

    public BaseWidget(int tag, int viewId) {
        mTag = tag;
        mResourceViewId = viewId;
    }

    public int getTag() { return mTag; }
    public View getView() { return mView; }
    public abstract View generateView(View parent);
}
