package com.brunocapezzali.androiduiactionsheet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunocapezzali on 14/07/2014.
 *
 */
public class AndroidActionSheet extends PopupWindow implements View.OnTouchListener {

    private enum ActionSheetStatus {
        OPENING, CLOSING, OPENED, CLOSED
    }

    private final static int CLOSE_AFTER_DELAY = 210;

    private Activity mActivity;
    private LinearLayout mBackground;
    private LinearLayout mWidgetsContainer;
    private List<BaseWidget> mWidgets;
    private ActionSheetStatus mStatus;

    public AndroidActionSheet(Activity activity) {
        super();
        mActivity = activity;
        mWidgets = new ArrayList<BaseWidget>();
        mStatus = ActionSheetStatus.CLOSED;
        initPopup();
    }

    private void initPopup() {

        LayoutInflater layoutInflater = (LayoutInflater)mActivity.getBaseContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = layoutInflater.inflate(R.layout.action_sheet_layout, null);
        setContentView(contentView);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

        setBackgroundDrawable(new ColorDrawable()); // FIX for touch event
        setTouchable(true);
        setTouchInterceptor(this);

        mBackground = (LinearLayout)contentView.findViewById(R.id.widget_background);
        mWidgetsContainer = (LinearLayout)contentView.findViewById(R.id.widget_container);
    }

    private boolean containsWidget(BaseWidget widget) {
        for ( int i=0; i< mWidgetsContainer.getChildCount(); ++i ) {
            if ( mWidgetsContainer.getChildAt(i) == widget.getView() ) {
                return true;
            }
        }
        return false;
    }

    private void refreshWidgets() {
        for (BaseWidget widget : mWidgets) {
            if ( !containsWidget(widget) ) {
                mWidgetsContainer.addView(widget.getView());
            }
        }
    }

    public void addWidget(BaseWidget widget) {
        mWidgets.add(widget);
        widget.generateView(mWidgetsContainer);
        refreshWidgets();
    }

    public void show() {
        if ( mStatus != ActionSheetStatus.CLOSED ) {
            return;
        }

        mStatus = ActionSheetStatus.OPENING;
        View mainView = mActivity.findViewById(android.R.id.content);
        showAtLocation(mainView, Gravity.CENTER, 0, 0);
        onEnterAnimation();
        final android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mStatus = ActionSheetStatus.OPENED;
            }
        }, CLOSE_AFTER_DELAY);
    }

    @Override
    public void dismiss() {
        if ( mStatus != ActionSheetStatus.OPENED ) {
            return;
        }

        mStatus = ActionSheetStatus.CLOSING;
        onExitAnimation();
        final android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mStatus = ActionSheetStatus.CLOSED;
                close();
            }
        }, CLOSE_AFTER_DELAY);
    }

    private void close() {
        super.dismiss();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
            Rect containerRect = new Rect();
            mWidgetsContainer.getHitRect(containerRect);
            if ( !containerRect .contains((int)event.getX(), (int)event.getY()) ) {
                dismiss();
                return true;
            }
        }
        return false;
    }

    private void onEnterAnimation() {
        mBackground.startAnimation(AnimationUtils.loadAnimation(mActivity, R.anim.fadein));
        mWidgetsContainer.startAnimation(AnimationUtils.loadAnimation(mActivity, R.anim.appear));
    }

    private void onExitAnimation() {
        mBackground.startAnimation(AnimationUtils.loadAnimation(mActivity, R.anim.fadeout));
        mWidgetsContainer.startAnimation(AnimationUtils.loadAnimation(mActivity, R.anim.disappear));
    }
}
