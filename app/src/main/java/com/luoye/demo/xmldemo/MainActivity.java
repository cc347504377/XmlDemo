package com.luoye.demo.xmldemo;

import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Info> infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = (ImageView) findViewById(R.id.image);
        AnimationDrawable drawable = (AnimationDrawable) view.getDrawable();
        drawable.start();
        try {
            infos = Xml.getinstance().parse(getResources().openRawResource(R.raw.test));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Info info : infos) {
            Log.i("TAG", info.toString());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TAG", event.getX()+"");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", " ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", " ACTION_UP");
                break;
            case MotionEvent.ACTION_HOVER_MOVE:
                Log.i("TAG", " ACTION_HOVER_MOVE");
                break;
            case MotionEvent.ACTION_SCROLL:
                Log.i("TAG", " ACTION_SCROLL");
                break;
            case MotionEvent.ACTION_BUTTON_PRESS:
                Log.i("TAG", " ACTION_BUTTON_PRESS");
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "你他妈在逗我", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Yse", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .create()
                    .show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
