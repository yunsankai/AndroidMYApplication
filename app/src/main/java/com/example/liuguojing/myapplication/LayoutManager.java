package com.example.liuguojing.myapplication;

/**
 * Created by liuguojing on 15/9/14.
 */

import android.widget.RelativeLayout;

import com.example.liuguojing.myapplication.Frame;

public class LayoutManager {

    static public RelativeLayout.LayoutParams getLayoutParmsWithFrame(Frame frame){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(frame.width, frame.height);
        layoutParams.leftMargin=frame.x;
        layoutParams.topMargin=frame.y;
        layoutParams.rightMargin=frame.width+frame.x;
        layoutParams.bottomMargin=frame.height+frame.y;
        return layoutParams;
    }

}
