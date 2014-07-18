package com.brunocapezzali.androiduiactionsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by Bruno Capezzali on 14/07/2014.
 *
 */
public class ButtonWidget extends BaseWidget {

    private String mLabel;
    private OnWidgetClickListener mClickListener;

    public ButtonWidget(int tag, String label, OnWidgetClickListener onClickListener) {
        super(tag, R.layout.button_widget);
        mLabel = label;
        mClickListener = onClickListener;
    }

    public ButtonWidget(String label, OnWidgetClickListener onClickListener) {
        super(0, R.layout.button_widget);
        mLabel = label;
        mClickListener = onClickListener;
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
            mView= layoutInflater.inflate(mResourceViewId, null);

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
