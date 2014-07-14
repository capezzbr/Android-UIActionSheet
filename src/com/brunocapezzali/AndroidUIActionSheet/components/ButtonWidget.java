package com.brunocapezzali.AndroidUIActionSheet.components;

import android.view.View;
import com.brunocapezzali.AndroidUIActionSheet.R;

/**
 * Created by brunocapezzali on 14/07/2014.
 */
public class ButtonWidget extends BaseWidget {

    public ButtonWidget(String label, View.OnClickListener onClickListener) {
        super(R.layout.button_widget);
    }

    @Override
    public View getView(View parent) {
        return null;
    }
}
