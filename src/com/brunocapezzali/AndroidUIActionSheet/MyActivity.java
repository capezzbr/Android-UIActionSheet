package com.brunocapezzali.AndroidUIActionSheet;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.brunocapezzali.AndroidUIActionSheet.components.*;

public class MyActivity extends Activity implements OnWidgetClickListener {

    AndroidActionSheet mActionSheet;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mActionSheet = new AndroidActionSheet(this);
        mActionSheet.addWidget(new ButtonWidget("Export", this));
        mActionSheet.addWidget(new ButtonWidget("Test all", this));
        mActionSheet.addWidget(new SpaceWidget());
        mActionSheet.addWidget(new ButtonWidget("Save all", this));
    }

    public void openPopup(View view) {
        mActionSheet.show();
    }

    @Override
    public void onClicked(BaseWidget widget) {
        ButtonWidget button = (ButtonWidget)widget;
        Toast.makeText(widget.getView().getContext(), "Button Clicked: "+ button.getLabel(), Toast.LENGTH_SHORT).show();

    }
}
