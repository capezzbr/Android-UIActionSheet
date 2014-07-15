package com.brunocapezzali.AndroidUIActionSheet.components;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.brunocapezzali.AndroidUIActionSheet.R;

/**
 * Created by brunocapezzali on 14/07/2014.
 */
public class ButtonWidget extends BaseWidget {

    private int mTag;
    private String mLabel;
    private OnWidgetClickListener mClickListener;

    public ButtonWidget(String label, OnWidgetClickListener onClickListener) {
        super(R.layout.button_widget);
        mLabel = label;
        mClickListener = onClickListener;
    }

    public void setTag(int tag) {
        mTag = tag;
    }

    public int getTag() {
        return mTag;
    }

    public String getLabel() {
        return mLabel;
    }

    @Override
    public View generateView(View parent) {
        if ( parent == null )
            return null;

        if ( mView == null ) {
            Context ctx = parent.getContext();
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView= layoutInflater.inflate(mViewId, null);

            Button btn = (Button)mView.findViewById(R.id.button);
            btn.setText(mLabel);

            final BaseWidget self = this;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.onClicked(self);
                }
            });
            btn.setEnabled(true);
        }
        return mView;
    }
}
