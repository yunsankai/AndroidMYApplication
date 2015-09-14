package com.example.liuguojing.myapplication;

import android.util.Log;

/**
 * Created by liuguojing on 15/9/14.
 */
public class Frame {
    public int x;
    public int y;
    public int width;
    public int height;

    public static void LogFame(Frame frame){
        Log.d("DEBUG","frame is x="+frame.x+"\ny="+frame.y+"\nwidth="+frame.width+"\nheight="+frame.height);
    }

    Frame(int _x, int _y, int _width ,int _height){
        x = _x;y = _y;width = _width;height = _height;
    }
}
