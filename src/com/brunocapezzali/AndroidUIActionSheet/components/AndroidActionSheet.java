package com.brunocapezzali.AndroidUIActionSheet.components;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.brunocapezzali.AndroidUIActionSheet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunocapezzali on 14/07/2014.
 *
 */
public class AndroidActionSheet extends PopupWindow {

    private Activity mActivity;
    private LinearLayout mLayoutContent;
    private List<BaseWidget> mWidgets;

    public AndroidActionSheet() {
        super();
        mWidgets = new ArrayList<BaseWidget>();
    }

    private void initPopup() {

        // create the basic structure of the layout
        LayoutInflater layoutInflater = (LayoutInflater)mActivity.getBaseContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mLayoutContent = new LinearLayout(mActivity);
        mLayoutContent.setBackgroundColor(Color.TRANSPARENT);
        mLayoutContent.setOrientation(LinearLayout.VERTICAL);
        setContentView(mLayoutContent);

        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
    }

    private void refreshWidgets() {
        View widgetView;
        for (BaseWidget widget : mWidgets) {
            if ( mLayoutContent.findViewById(widget.getViewId()) == null ) {
                mLayoutContent.addView(widget.getView(mLayoutContent));
            }
        }
    }

    public void addWidget(BaseWidget widget) {
        mWidgets.add(widget);
        refreshWidgets();
    }

}
