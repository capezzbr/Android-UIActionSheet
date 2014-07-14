package com.brunocapezzali.AndroidUIActionSheet.components;

import android.view.View;

/**
 * Created by brunocapezzali on 14/07/2014.
 *
 */
public abstract class BaseWidget {

    private int mViewId;

    public BaseWidget(int viewId) {
        mViewId = viewId;
    }

    public int getViewId() { return mViewId; }
    public abstract View getView(View parent);
}
