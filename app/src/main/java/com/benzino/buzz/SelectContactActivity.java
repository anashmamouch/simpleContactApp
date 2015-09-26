package com.benzino.buzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class SelectContactActivity extends BaseActivity {
    public static final String DATA = "DATA" ;
    public static final String RESULT_CONTACT_NAME = "RESULT_CONTACT_NAME";
    private static final int REQUEST_SEARCH_CONTACTS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        TextView title = (TextView)findViewById(R.id.activity_select_contact_title);
        title.setText(getIntent().getStringExtra(DATA));

        findViewById(R.id.activity_select_contact_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectContactActivity.this, SearchActivity.class);
                startActivityForResult(intent, REQUEST_SEARCH_CONTACTS);
            }
        });

        findViewById(R.id.activity_select_contact_contact_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectContact("Contact 1");
            }
        });

        findViewById(R.id.activity_select_contact_contact_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectContact("Contact 2");
            }
        });

        findViewById(R.id.activity_select_contact_contact_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectContact("Contact 3");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SEARCH_CONTACTS){
            if (resultCode == RESULT_OK){
                String contactName = data.getStringExtra(SearchActivity.RESULT_CONTACT_NAME);
                selectContact(contactName);
            }
        }
    }

    public void selectContact(String contactName){
        Intent data = new Intent();
        data.putExtra(RESULT_CONTACT_NAME, contactName);
        setResult(RESULT_OK, data);
        finish();
    }

}
