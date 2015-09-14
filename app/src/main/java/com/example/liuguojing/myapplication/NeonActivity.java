package com.example.liuguojing.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import android.os.CountDownTimer;
/**
 * Created by liuguojing on 15/9/14.
 */
public class NeonActivity extends AppCompatActivity {

    private RelativeLayout insertLayout;
    private int colorArrayList[] = {Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.CYAN,Color.GRAY};
    private CountDownTimer timer;
    private boolean timerInUse = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neon_activity);

        insertLayout = (RelativeLayout)findViewById(R.id.background_layout);//screen是一个RelativeLayout 布局的id
        View enptyView = findViewById(R.id.empty_view);
        int width = 800;
        int height = 1100;
        int space = 60;

        for (int i = 0; i < 7; i++){
            Frame frame = new Frame(space*i,space*i,width-space*i*2,height-space*i*2);
            Frame.LogFame(frame);
            RelativeLayout.LayoutParams layoutParams = LayoutManager.getLayoutParmsWithFrame(frame);
            View view = new View(this);
            insertLayout.addView(view, layoutParams);
            view.setBackgroundColor(colorArrayList[i]);
        }

         timer = new CountDownTimer(2147483647,1) {
            @Override
            public void onTick(long millisUntilFinished) {

                for (int i = 1; i < insertLayout.getChildCount(); i++){
                    View view = insertLayout.getChildAt(i);
                    int colorIndex = ((int)millisUntilFinished/1000+i)%7;
                    view.setBackgroundColor(colorArrayList[colorIndex]);
                }
                timerInUse = true;
            }

            @Override
            public void onFinish() {
                timerInUse = false;
            }
        };
        timer.start();

    }
//返回按钮
    public void backButtonClicked(View view){
        this.finish();
    }
//暂停按钮
    public void pauseButtonClicked(View view){
        if (timerInUse){
            timerInUse = false;
            timer.cancel();
        }else {
            timer.start();
        }
    }

}
