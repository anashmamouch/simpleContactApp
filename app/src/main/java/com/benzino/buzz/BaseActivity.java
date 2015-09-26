package com.benzino.buzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public abstract class BaseActivity  extends AppCompatActivity{
    public static boolean isLoggedIn = false;

    private String tag = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isLoggedIn && getClass() != LoginActivity.class){
            startActivity(new Intent(this, LoginActivity.class));
            Log.d("ANAS | " + tag, "--onCreate being replaced by Login activity ");
            finish();
            return;
        }else{
            Log.d("ANAS | " + tag, "--onCreate ");
        }
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
