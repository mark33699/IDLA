package com.example.idla;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MarkFly","Hello World");
        if (BuildConfig.foo)
        {
            TextView textView = findViewById(R.id.main_label);
            textView.setText("我是傻子");
        }
    }
}
