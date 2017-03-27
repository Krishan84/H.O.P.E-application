package com.bsaitm.krishanpal.hope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.ViewGroup;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        String Name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String Emailaddress=intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String Phone= intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String Address= intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String Description= intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        TextView textView = (TextView) findViewById(R.id.textView17);
        TextView textView1= (TextView) findViewById(R.id.textView15);
        TextView textView2= (TextView) findViewById(R.id.textView13);
        TextView textView3= (TextView) findViewById(R.id.textView11);
        TextView textView4=(TextView)  findViewById(R.id.emailkk);
        textView1.setText(Phone);
        textView2.setText(Address);
        textView3.setText(Description);
        textView.setText(Name);
        textView4.setText(Emailaddress);

    }
}
