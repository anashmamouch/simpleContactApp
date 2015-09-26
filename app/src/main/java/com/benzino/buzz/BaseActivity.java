package com.benzino.buzz;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public abstract class BaseActivity  extends AppCompatActivity{
    private String tag = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ANAS | "+tag, "--onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ANAS | "+tag, "--onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ANAS | "+tag, "--onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ANAS | "+tag, "--onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ANAS | " + tag, "--onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ANAS | "+tag, "--onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onRestart();
        Log.d("ANAS | "+tag, "--onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ANAS | " + tag, "--onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("ANAS | " + tag, "--onRestoreInstanceState ");
    }
}
