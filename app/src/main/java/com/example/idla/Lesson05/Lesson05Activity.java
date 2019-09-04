package com.example.idla.Lesson05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson05Activity extends BaseActivity
{
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson05);

        btnNext = findViewById(R.id.lesson05_btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson05Activity.this, ConstraintLayoutActivity.class);
                intent.putExtra("title",Lesson05Activity.this.getTitle());
                startActivity(intent);
            }
        });
    }
}
