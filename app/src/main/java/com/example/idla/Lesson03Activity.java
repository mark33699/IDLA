package com.example.idla;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Lesson03Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03);
        Log.i("MarkFly",this.getLocalClassName() + " -> create -> 我出生了");
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
}
