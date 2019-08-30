package com.example.idla.Lesson03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class LaunchActivity extends BaseActivity {

    private TextView textView;
    protected Button button;
    protected LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        linearLayout = findViewById(R.id.launch_linear_layout);
        button = findViewById(R.id.launch_btn);
        textView = findViewById(R.id.launch_text);
        textView.setText(this.toString() + "\ncurrent task:" + this.getTaskId() + ""); // 不懂為何一定要加在結尾, 前面已經是字串了不是嗎？
    }
}