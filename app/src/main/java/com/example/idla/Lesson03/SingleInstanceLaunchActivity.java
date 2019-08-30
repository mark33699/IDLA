package com.example.idla.Lesson03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.idla.R;

public class SingleInstanceLaunchActivity extends LaunchActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //因為在當前Task已經有SingleInstanceLaunchActivity了, 就直接使用, 所以這邊Intent是無效的
                startActivity(new Intent(SingleInstanceLaunchActivity.this,SingleInstanceLaunchActivity.class));
            }
        });
    }
}
