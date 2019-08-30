package com.example.idla.Lesson03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson03Activity extends BaseActivity {

    private Button btnStandard;
    private Button btnSingleTop;
    private Button btnSingleTask;
    private Button btnSingleInstance;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03);
        Log.i("MarkFly",this.getLocalClassName() + " -> create -> 我出生了");

        textView = findViewById(R.id.lesson03_textView);
        textView.setText("current task: " + this.getTaskId() + "");

        setupButton();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MarkFly", this.getLocalClassName() + " -> start -> 我開始了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MarkFly",this.getLocalClassName() + " -> resume -> 我復活了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MarkFly",this.getLocalClassName() + " -> pause -> 我暫停了");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MarkFly",this.getLocalClassName() + " -> stop -> 我停止了");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MarkFly",this.getLocalClassName() + " -> restart -> 我又開始了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MarkFly",this.getLocalClassName() + " -> destroy -> 我死亡了");
    }

    private void setupButton()
    {
        btnStandard = findViewById(R.id.lesson03_btn_standard);
        btnSingleTop = findViewById(R.id.lesson03_btn_singleTop);
        btnSingleTask = findViewById(R.id.lesson03_btn_singleTask);
        btnSingleInstance = findViewById(R.id.lesson03_btn_singleInstance);

        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson03Activity.this,StandardLaunchActivity.class);
                intent.putExtra("title",btnStandard.getText());
                startActivity(intent);
            }
        });
        btnSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson03Activity.this,SingleTopLaunchActivity.class);
                intent.putExtra("title",btnSingleTop.getText());
                startActivity(intent);
            }
        });
        btnSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson03Activity.this,SingleTaskLaunchActivity.class);
                intent.putExtra("title",btnSingleTask.getText());
                startActivity(intent);
            }
        });
        btnSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson03Activity.this,SingleInstanceLaunchActivity.class);
                intent.putExtra("title",btnSingleInstance.getText());
                startActivity(intent);
            }
        });
    }
}
