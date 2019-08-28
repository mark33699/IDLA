package com.example.idla.Lesson03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.idla.R;

public class StandardLaunchActivity extends LaunchActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_launch);//要用人家的畫面就不能自己又讀一次

        linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StandardLaunchActivity.this,StandardLaunchActivity.class);
                startActivity(intent);
            }
        });
    }
}
