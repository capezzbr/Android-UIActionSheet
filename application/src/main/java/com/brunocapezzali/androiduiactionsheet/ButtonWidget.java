package com.brunocapezzali.androiduiactionsheet;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

    private Drawable mIcon = null;
    private int mIconPadding;

    public ButtonWidget(String label, OnWidgetClickListener onClickListener) {
        super(R.layout.button_widget);
        init(-1, label, null, 0, onClickListener);
    }

    public ButtonWidget(int tag, String label, Drawable icon, int iconPadding,
                        OnWidgetClickListener onClickListener) {

        super(R.layout.button_widget);
        init(tag, label, icon, iconPadding, onClickListener);
    }

    public void init(int tag, String label, Drawable icon, int iconPadding,
                     OnWidgetClickListener onClickListener) {
        mTag = tag;
        mLabel = label;
        mIcon = icon;
        mIconPadding = iconPadding;
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
            LayoutInflater layoutInflater = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = layoutInflater.inflate(mResourceViewId, null);

            Button btn = (Button)mView.findViewById(R.id.button);
            btn.setText(mLabel);

            if ( mIcon != null ) {
                btn.setCompoundDrawablesWithIntrinsicBounds(mIcon, null, null, null);
                btn.setCompoundDrawablePadding(mIconPadding);
            }

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
