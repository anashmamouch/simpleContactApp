package com.benzino.buzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_SELECT_CONTACT = 101;

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.activity_main_text);
        editText = (EditText) findViewById(R.id.activity_main_editText);
        button = (Button) findViewById(R.id.activity_main_button);

        button.setOnClickListener(this);

        findViewById(R.id.activity_main_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity.isLoggedIn = false;
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
       if (view == button){
           Intent intent = new Intent(this, SelectContactActivity.class);
           intent.putExtra(SelectContactActivity.DATA, editText.getText().toString());
           startActivityForResult(intent, REQUEST_SELECT_CONTACT);
       }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_CONTACT ){
            if(resultCode == RESULT_OK){
                String contactName = data.getStringExtra(SelectContactActivity.RESULT_CONTACT_NAME);
                textView.setText("You selected " + contactName );
            } else {
                textView.setText("There was an error");
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }



    }
}

