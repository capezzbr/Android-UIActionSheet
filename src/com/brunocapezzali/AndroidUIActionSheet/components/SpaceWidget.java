package com.brunocapezzali.AndroidUIActionSheet.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.brunocapezzali.AndroidUIActionSheet.R;

/**
 * Created by brunocapezzali on 15/07/2014.
 */
public class SpaceWidget extends BaseWidget {

    public SpaceWidget() {
        super(R.layout.space_widget);
    }

    @Override
    public View generateView(View parent) {
        if ( parent == null )
            return null;

        if ( mView == null ) {
            Context ctx = parent.getContext();
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = layoutInflater.inflate(mViewId, null);
        }
        return mView;
    }
}
