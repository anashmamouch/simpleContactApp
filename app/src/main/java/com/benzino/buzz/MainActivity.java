package com.benzino.buzz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity{

    private int counter;
    private static final String BUNDLE_COUNTER = "BUNDLE_COUNTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
            counter = savedInstanceState.getInt(BUNDLE_COUNTER);

        final TextView textView = (TextView) findViewById(R.id.activity_main_text);
        final Button button = (Button) findViewById(R.id.activity_main_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText(Integer.toString(counter));
            }
        });

        textView.setText(Integer.toString(counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_COUNTER, counter);
    }
}

