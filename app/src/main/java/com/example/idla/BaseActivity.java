package com.example.idla;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        String title = getIntent().getStringExtra("title");
        title = title == null ? "null" : title;
        Log.d("MF",title);
        this.setTitle(title);
    }
}
