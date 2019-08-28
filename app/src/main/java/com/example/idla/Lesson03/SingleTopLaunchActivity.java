package com.example.idla.Lesson03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.idla.R;

public class SingleTopLaunchActivity extends LaunchActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingleTopLaunchActivity.this,SingleTopLaunchActivity.class));
            }
        });
    }
}
