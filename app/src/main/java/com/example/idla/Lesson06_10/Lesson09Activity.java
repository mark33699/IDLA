package com.example.idla.Lesson06_10;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

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

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radioButton:
                        Toast.makeText(Lesson09Activity.this,"高",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(Lesson09Activity.this,"富",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(Lesson09Activity.this,"帥",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

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
