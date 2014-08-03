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
        mActionSheet.addWidget(new ButtonWidget(1, "Export", this));
        mActionSheet.addWidget(new ButtonWidget(2, "Test all", this));
        mActionSheet.addWidget(new DividerWidget());
        mActionSheet.addWidget(new ButtonWidget(3, "Save all", this));
    }

    public void openPopup(View view) {
        mActionSheet.show();
    }

    @Override
    public void onClicked(BaseWidget widget) {
        ButtonWidget button = (ButtonWidget)widget;
        String label = button.getLabel();
        int tag = button.getTag();

        Toast.makeText(widget.getView().getContext(), "Button #"+ tag +" clicked: " + label,
                Toast.LENGTH_SHORT).show();
    }
}
