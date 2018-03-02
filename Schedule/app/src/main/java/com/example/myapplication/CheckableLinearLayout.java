package com.example.myapplication;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Checkable;

/**
 * Created by JeonWon on 2018-03-01.
 */

public class CheckableLinearLayout extends LinearLayout implements Checkable {
    public CheckableLinearLayout(Context context) {
        super(context);
    }

    @Override
    public void setChecked(boolean checked) {
        CheckBox chkBox = (CheckBox)findViewById(R.id.checkBox);

        if(chkBox.isChecked() != checked){
            chkBox.setSelected(checked);
        }
    }

    @Override
    public boolean isChecked() {
        CheckBox chkBox = (CheckBox)findViewById(R.id.checkBox);

        return chkBox.isChecked();
    }

    @Override
    public void toggle() {
        CheckBox chkBox = (CheckBox)findViewById(R.id.checkBox);

        setChecked(chkBox.isChecked()?false:true);
    }
}
