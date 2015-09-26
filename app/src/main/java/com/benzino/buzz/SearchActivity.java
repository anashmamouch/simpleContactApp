package com.benzino.buzz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class SearchActivity extends BaseActivity {
    public static final String RESULT_CONTACT_NAME = "RESULT_CONTACT_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final EditText text  = (EditText) findViewById(R.id.activity_search_searchText);

        findViewById(R.id.activity_search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(RESULT_CONTACT_NAME, text.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });

        findViewById(R.id.activity_search_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

}
