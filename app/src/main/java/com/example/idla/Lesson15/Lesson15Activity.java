package com.example.idla.Lesson15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson15Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson15);
    }

    public void goToDrawer(View view)
    {
        startActivity(new Intent(this, Lesson15DrawerActivity.class));
    }

    public void goToTabbed(View view)
    {
        startActivity(new Intent(this, Lesson15TabbedActivity.class));
    }

    public void goToMasterDetail(View view)
    {
        startActivity(new Intent(this, ActivityListActivity.class));
    }

    public void goToFullScreen(View view)
    {
        startActivity(new Intent(this, Lesson15FullscreenActivity.class));
    }
}
