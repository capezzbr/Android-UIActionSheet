package com.brunocapezzali.androiduiactionsheet;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Bruno Capezzali on 15/07/2014.
 */
public class SpaceWidget extends BaseWidget {

    private boolean mOnlySpace = true;
    private int mHeight;

    public SpaceWidget(int height) {
        super(R.layout.divider_widget);
        init(true, height);
    }

    public SpaceWidget() {
        super(R.layout.divider_widget);
        init(false, 0);
    }

    private void init(boolean onlySpace, int height) {
        mOnlySpace = onlySpace;
        mHeight = height;
    }

    @Override
    public View generateView(View parent) {
        if ( parent == null )
            return null;

        if ( mView == null ) {
            Context ctx = parent.getContext();
            LayoutInflater layoutInflater = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = layoutInflater.inflate(mResourceViewId, null);

            if ( mOnlySpace ) {
                LinearLayout container = (LinearLayout)mView.findViewById(R.id.container);
                setHeightToLinearLayout(container, mHeight);

                View lineView = mView.findViewById(R.id.viewLine);
                lineView.setVisibility(View.GONE);
            }
        }
        return mView;
    }

    private void setHeightToLinearLayout(LinearLayout layout, int height) {
        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.height = height;
        layout.setLayoutParams(layoutParams);
    }
}
