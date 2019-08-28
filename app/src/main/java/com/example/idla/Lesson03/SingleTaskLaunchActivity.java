package com.example.idla.Lesson03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.idla.MainActivity;
import com.example.idla.R;

public class SingleTaskLaunchActivity extends LaunchActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingleTaskLaunchActivity.this, MainActivity.class));
            }
        });
    }
}
