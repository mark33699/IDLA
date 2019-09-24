package com.example.idla.Lesson06_10;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

public class Lesson10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10);

        final TextView textViewDiscrete = findViewById(R.id.textView8);
        final TextView textViewContinue = findViewById(R.id.textView9);

        final SeekBar seekBarDiscrete = findViewById(R.id.seekBar2);
        final SeekBar seekBarContinue= findViewById(R.id.seekBar3);
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (seekBar == seekBarDiscrete)
                {
                   textViewDiscrete.setText(i + "");
                }
                else
                {
                    textViewContinue.setText(i + "");
                }
            }

            //吐司的特性, 會一個顯示完才顯示下一個
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Lesson10Activity.this, seekBar.getProgress() + "時按下",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Lesson10Activity.this,seekBar.getProgress() + "時放下",Toast.LENGTH_SHORT).show();
            }
        };
        seekBarDiscrete.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBarContinue.setOnSeekBarChangeListener(onSeekBarChangeListener);


        final ProgressBar progressBarHorizontal = findViewById(R.id.progressBar);
        final ProgressBar progressBarCircular = findViewById(R.id.progressBar2);
        Switch switchButton = findViewById(R.id.switch2);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                progressBarHorizontal.setIndeterminate(b);
                progressBarCircular.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

}
