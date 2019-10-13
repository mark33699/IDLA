package com.example.idla.Lesson20_22;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson20Activity extends BaseActivity
{
    androidx.appcompat.widget.Toolbar toolbarNewX;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson20);

        getSupportActionBar().hide();//NoActionBar時會閃退

        toolbarNewX = findViewById(R.id.mark_tool_bar);
        toolbarNewX.inflateMenu(R.menu.action_bar);
        toolbarNewX.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                return true;
            }
        });

//        setSupportActionBar(toolbarNewX); //有指定右上角會不見???
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void noActionBar(View view)
    {
        getSupportActionBar().hide();
    }

    public void newActionBar(View view)
    {
        getSupportActionBar().show();
    }
}
