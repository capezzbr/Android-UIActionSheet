package com.brunocapezzali.androiduiactionsheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DemoActivity extends Activity implements OnWidgetClickListener {

    AndroidActionSheet mActionSheet;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

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
        Toast.makeText(widget.getView().getContext(), "Button Clicked: " + button.getLabel(), Toast.LENGTH_SHORT).show();

    }
}
