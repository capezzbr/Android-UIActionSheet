package com.brunocapezzali.androiduiactionsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Bruno Capezzali on 15/07/2014.
 */
public class SpaceWidget extends BaseWidget {

    public SpaceWidget(int tag) { super(tag, R.layout.space_widget); }
    public SpaceWidget() {
        super(0, R.layout.space_widget);
    }

    @Override
    public View generateView(View parent) {
        if ( parent == null )
            return null;

        if ( mView == null ) {
            Context ctx = parent.getContext();
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = layoutInflater.inflate(mResourceViewId, null);
        }
        return mView;
    }
}
