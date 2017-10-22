package com.example.my.sampleandroid;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.my.sampleandroid.utils.BusEventHelper;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.txt);
        Button button = (Button) findViewById(R.id.buttonPanel);
        editText = (EditText) findViewById(R.id.edit_query);

        editText.setSelection(editText.getEditableText().toString().length());

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0 && charSequence.charAt(charSequence.length() - 1) == '\n') {
                    editText.setText("");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        editText.addTextChangedListener(textWatcher);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*i++;
                textView.setText(String.valueOf(i));*/

                //restartActivity();
                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "Yhos is from sandeep");
                startActivity(intent);*/

                /*Intent intent = new Intent();
                intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
                sendBroadcast(intent);*/

                Intent intent = new Intent(MainActivity.this, SecondLevelActivity.class);
                startActivity(intent);

            }
        });

    }



    private void restartActivity() {
        this.recreate();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString("KEY"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
