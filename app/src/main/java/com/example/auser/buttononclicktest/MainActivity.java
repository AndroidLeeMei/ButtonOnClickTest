package com.example.auser.buttononclicktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        tv=new TextView(this);
        tv.setText("Hello");
        bt=new Button(this);
        bt.setText("OK");
        linearLayout.addView(tv);
        linearLayout.addView(bt);

//        bt.setOnClickListener(new SampleClickListener());
        bt.setOnTouchListener(new SampleClickListener());
//        tv.setOnTouchListener(new SampleClickListener());

    }
//    class SampleClickListener implements View.OnClickListener,View.OnTouchListener{
//        @Override
//        public void onClick(View v) {//按左鍵時觸發
//            tv.setText("Welcome to app.");
//        }
        class SampleClickListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                tv.setText("MouseDown");
            }
            if (event.getAction()==MotionEvent.ACTION_UP){
                tv.setText("MouseUP");
            }
//            MotionEvent.ACTION_SCROLL 是使用在觸控面版上才有…
            return false;
        }
    }

    //先定位在class外,Code/@Override/找onKeyDown()
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String str;
        switch (keyCode){
//            case KeyEvent.KEYCODE_BUTTON_A:
//                str="A";
//                break;
//            case KeyEvent.KEYCODE_BUTTON_B:
//                str="B";
//                break;
//            case KeyEvent.KEYCODE_0:
//                str="0";
//                break;
            case KeyEvent.KEYCODE_DPAD_UP: //按上方
                str="KEYCODE_DPAD_UP";
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN://按下方鍵
                str="KEYCODE_DPAD_DOWN";
                break;
            default:
                str="Others";
        }
        tv.setText("Press " +str);

        return super.onKeyDown(keyCode, event);
    }
}
