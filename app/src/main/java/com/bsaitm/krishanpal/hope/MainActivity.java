package com.bsaitm.krishanpal.hope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE="com.example.myfirstapp.MESSAGE";
    public static String EXTRA_MESSAGE3="com.example.myfirstapp.MESSAGE3";
    public static String EXTRA_MESSAGE2="com.example.myfirstapp.MESSAGE2";
    public static String EXTRA_MESSAGE1="com.example.myfirstapp.MESSAGE1";
    public static String EXTRA_MESSAGE4="com.example.myfirstapp.MESSAGE4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitDetails(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        EditText editText2=(EditText) findViewById(R.id.editText5);
        EditText editText3=(EditText) findViewById(R.id.editText4);
        EditText editText4=(EditText) findViewById(R.id.editText3);
        EditText editText5=(EditText) findViewById(R.id.editText);
        EditText editText = (EditText) findViewById(R.id.editText6);
        String message3 = editText4.getText().toString();
        String message2 = editText3.getText().toString();
        String message1 = editText2.getText().toString();
        String message = editText.getText().toString();
        String message4=editText5.getText().toString();
        intent.putExtra(EXTRA_MESSAGE3,message3);
        intent.putExtra(EXTRA_MESSAGE2,message2);
       intent.putExtra(EXTRA_MESSAGE1,message1);
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.putExtra(EXTRA_MESSAGE4,message4);

        startActivity(intent);
    }

}
