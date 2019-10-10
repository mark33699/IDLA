package com.example.idla.Lesson20;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

public class Lesson20Activity extends AppCompatActivity
{
    android.widget.Toolbar toolbarNew;
    androidx.appcompat.widget.Toolbar toolbarNewX;
    ActionBar actionBarDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson20);

        actionBarDefault = getSupportActionBar();
        toolbarNew = findViewById(R.id.toolbar);
        toolbarNewX = findViewById(R.id.toolbar);
    }

    public void noActionBar(View view)
    {
        getSupportActionBar().hide();
    }

    public void defaultActionBar(View view)
    {
//        setSupportActionBar(actionBarDefault);
        getSupportActionBar().show();
    }

    public void newActionBar(View view)
    {
        setSupportActionBar(toolbarNewX);
        getSupportActionBar().show();

//        setActionBar(toolbarNew);
//        getActionBar().show();
    }
}
