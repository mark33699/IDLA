package com.example.idla.Lesson06;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson06Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson06);
    }

    public void didTap(View view)
    {
        view.setEnabled(false);
        Log.d("MarkFly","按！！！");
    }
}
