package com.brunocapezzali.androiduiactionsheet;

import android.widget.CheckBox;

/**
 * Created by capezzbr on 03/08/2014.
 */
public class CheckboxWidget extends ButtonWidget {
    boolean mChecked = false;
    CheckBox mCheckbox = null;

    OnWidgetClickListener mOnButtonClick = new OnWidgetClickListener() {
        @Override
        public void onClicked(BaseWidget widget) {
            if ( mCheckbox == null ) {
                mCheckbox = (CheckBox)widget.getView().findViewById(R.id.checkbox);
                mCheckbox.setClickable(false);
            }
            mChecked = !mChecked;
            mCheckbox.setChecked(mChecked);
        }
    };

    public CheckboxWidget(String label) {
        super(R.layout.checkbox_widget);
        super.init(label, mOnButtonClick);
    }

    public boolean isChecked() {
        return mChecked;
    }
}
