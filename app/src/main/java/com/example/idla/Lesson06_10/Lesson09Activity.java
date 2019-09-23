package com.example.idla.Lesson06_10;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;
import com.google.android.material.chip.Chip;

public class Lesson09Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson09);

        Chip chip1 = findViewById(R.id.chip);
        chip1.setOnCloseIconClickListener(createClickListener());
        Chip chip2 = findViewById(R.id.chip2);
        chip2.setOnCloseIconClickListener(createClickListener());
        Chip chip3 = findViewById(R.id.chip3);
        chip3.setOnCloseIconClickListener(createClickListener());
        Chip chip4 = findViewById(R.id.chip4);
        chip4.setOnCloseIconClickListener(createClickListener());

    }

    private View.OnClickListener createClickListener()
    {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MF", getResources().getResourceEntryName(view.getId()));
                view.setVisibility(View.GONE);
            }
        };
        return onClickListener;
    }
}
