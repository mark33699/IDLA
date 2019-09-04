package com.example.idla.Lesson04;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson04Activity extends BaseActivity {

    private Button buttonR;
    private Button buttonF;
    private Button buttonA;
    private Button buttonT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04);

        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        Button button = new Button(this);
        button.setText("new button by code");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        button.setLayoutParams(layoutParams);
        linearLayout.addView(button);

        buttonR = findViewById(R.id.lesson04_btn_relative);
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(view, RelativeLayoutActivity.class);
            }
        });

        buttonF = findViewById(R.id.lesson04_btn_frame);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(view, FrameLayoutActivity.class);
            }
        });

        buttonA = findViewById(R.id.lesson04_btn_absolute);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(view, AbsoluteLayoutActivity.class);
            }
        });

        buttonT = findViewById(R.id.lesson04_btn_table);
        buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(view, TableLayoutActivity.class);
            }
        });
    }

    private void startActivity(View view, Class cls) {
        Intent intent = new Intent(Lesson04Activity.this, cls);
        Button button = (Button)view;
        intent.putExtra("title",button.getText());
        startActivity(intent);
    }
}
