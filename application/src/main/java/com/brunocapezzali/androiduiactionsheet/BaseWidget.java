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

    public BaseWidget(int viewId) {
        mResourceViewId = viewId;
    }

    public int getResourceViewId() { return mResourceViewId; }

    public abstract View generateView(View parent);
    public View getView() { return mView; }

    public int getTag() { return mTag; }
    public void setTag(int tag) { mTag = tag; }
}
