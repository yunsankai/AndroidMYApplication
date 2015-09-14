
package com.example.liuguojing.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.util.Log;

import java.util.ArrayList;
import com.example.liuguojing.myapplication.NeonActivity;
import com.example.liuguojing.myapplication.LayoutManager;
import com.example.liuguojing.myapplication.Frame;

class CustomButton extends Button{
    public int mTag;
    public boolean isSelected;
    public CustomButton(Context ctx){
        super(ctx);
    };
}


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public ArrayList<CustomButton> subViews;
    private Button newButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        System.out.println(new Throwable().getStackTrace()[0]);
//        int theView = R.id.fuck;
//        System.out.print("呵呵");

        newButton = (Button)findViewById(R.id.newbutton);

        Log.d("DEBUG", "呵呵");

       
        subViews = new ArrayList<CustomButton>();
        int width = 50;
        int space = 10;
        for (int i = 0; i < 5; i++){

            for (int j = 0; j< 7; j++){
                CustomButton button = new CustomButton(this);
//                button.setLayoutParams(new ViewGroup.LayoutParams(20,20));
                RelativeLayout insertLayout = (RelativeLayout)findViewById(R.id.main_activity);//screen是一个RelativeLayout 布局的id
                Frame frame = new Frame(space + j * (width+space),space + (width+space) * i,width,width);
                RelativeLayout.LayoutParams layoutParams = LayoutManager.getLayoutParmsWithFrame(frame);
                insertLayout.addView(button, layoutParams);
//                addContentView(button, new ViewGroup.LayoutParams(20, 20));
                button.setBackgroundColor(Color.BLACK);
//                setLayout(button, 10 + j * 30, 10 + 30 * i);
                button.mTag = i*100 + j;
                button.isSelected = false;
                button.setOnClickListener(this);
                subViews.add(i * 7 + j, button);
            }
        }

    }

    public CustomButton viewWithTag(int mTag){
        int i = mTag/100, j = mTag%100;
        int index = i*7+j;
        if (index >= subViews.size() || index < 0){
            return null;
        }
        return (CustomButton)subViews.get(index);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof CustomButton){
            CustomButton button = (CustomButton)v;
            customButtonSetState(button);
            int mTag = button.mTag;
            Log.d("DEBUG","click mTag is "+mTag);
            for (int i = 0; i < 4;i++){
                int index = 0;
                switch (i){
                    case 0:index = mTag-1;break;
                    case 1:index = mTag+1;break;
                    case 2:index = mTag-100;break;
                    case 3:index = mTag+100;break;
                }
                Log.d("DEBUG","mTag is"+index);
                //判断如果
                if ((index%10 == 7 || index%10 == 9) && index != 0){
                    index = -1;
                }
                CustomButton buttonLeft = viewWithTag(index);
                if (buttonLeft != null) {
                    customButtonSetState(buttonLeft);
                }
            }
        }else if(v == newButton){
            Intent it = new Intent();
            it.setClass(this, NeonActivity.class);
            startActivity(it);
        }

    }
    public void customButtonSetState(CustomButton button){
        if (button.isSelected){
            button.setBackgroundColor(Color.BLACK);
        }else {
            button.setBackgroundColor(Color.YELLOW);
        }
        button.isSelected = !button.isSelected;
    }
    public void fuckButtonClicked(View view){
        Log.d("DEBUG","fuckButtonClicked");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        System.out.println(new Throwable().getStackTrace()[0]);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
//        System.out.println(new Throwable().getStackTrace()[0]);

        return super.onOptionsItemSelected(item);
    }

//    public List componentsSeparatedByString(String aString,String byString){
//
//        List stringArray = new ArrayList();
//        List indexArray = new ArrayList();
//        Integer startIndex = -1;
//        indexArray.add(startIndex);
//        while (true){
//            startIndex = aString.indexOf(byString,startIndex+1);
//            if (startIndex == -1){
//                break;
//            }else {
//                indexArray.add(startIndex);
//            }
//        }
//        for (int i = 0; i < indexArray.size(); i++){
//            Integer location = (Integer)indexArray.get(i);
//            Integer nextIndex;
//            if ((i+1) >= indexArray.size()){
//                nextIndex = aString.length();
//            }else {
//                nextIndex = (Integer)indexArray.get(i+1);
//            }
//            String tempString = aString.substring(location+1,nextIndex);
//            stringArray.add(tempString);
//
//        }
//        return stringArray;
//    }
    
    
}


   