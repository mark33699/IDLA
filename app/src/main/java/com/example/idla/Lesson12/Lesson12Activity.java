package com.example.idla.Lesson12;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.idla.BaseActivity;
import com.example.idla.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Lesson12Activity extends BaseActivity
{
    private enum FragmentType
    {
        red,
        yellow,
        green
    }

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson12);
        frameLayout = findViewById(R.id.frame_layout_for_fragment);

        changeFragment(FragmentType.red);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.bottom_navi_red:
                        changeFragment(FragmentType.red);
                        return true;
                    case R.id.bottom_navi_yellow:
                        changeFragment(FragmentType.yellow);
                        return true;
                    case R.id.bottom_navi_green:
                        changeFragment(FragmentType.green);
                        return true;
                }
                return false;
            }
        });
    }

    private void changeFragment(FragmentType index)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (index)
        {
            case red:
                fragmentTransaction.replace(R.id.frame_layout_for_fragment,new RedFragment());
                break;
            case yellow:
                fragmentTransaction.replace(R.id.frame_layout_for_fragment,new YellowFragment());
                break;
            case green:
                fragmentTransaction.replace(R.id.frame_layout_for_fragment,new GreenFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}
