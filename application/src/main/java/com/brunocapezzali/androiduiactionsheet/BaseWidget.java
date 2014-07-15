package com.brunocapezzali.androiduiactionsheet;

import android.view.View;

/**
 * Created by brunocapezzali on 14/07/2014.
 *
 */
public abstract class BaseWidget {

    protected int mViewId;
    protected View mView = null;

    public BaseWidget(int viewId) {
        mViewId = viewId;
    }

    public int getViewId() { return mViewId; }
    public View getView() { return mView; }
    public abstract View generateView(View parent);
}
