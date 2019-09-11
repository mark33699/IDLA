package com.example.idla.Lesson06;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.idla.BaseActivity;
import com.example.idla.R;

public class Lesson06Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson06);
    }

    public void didTap(View view)
    {
        view.setEnabled(false);
        Log.d("MarkFly","按！！！");
    }

    public void threeChooseOneDialog(View view)
    {
        Dialog dialog = new AlertDialog.Builder(this)

                .setTitle("請問！")
                .setMessage("現在是白天還是晚上？")
                .setPositiveButton("白天", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Lesson06Activity.this,"您選擇的是白天",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("晚上", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Lesson06Activity.this,"您選擇的是晚上",Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("我不知道", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Lesson06Activity.this,"那麼我明天再問您一次",Toast.LENGTH_LONG).show();
                    }
                }).create();

        dialog.show();
    }

    public void selectListDialog(View view)
    {
        final String[] season = {"春天","夏天","秋天","冬天"};

        Dialog dialog = new AlertDialog.Builder(this)

                .setTitle("請問您喜歡哪個季節？")
//                .setMessage("隨便") 加這行選項就都不見
                .setItems(season, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Lesson06Activity.this,"好巧喔❤️我也好愛" + season[i], Toast.LENGTH_LONG).show();
                    }
                }).create();

        dialog.show();
    }

    public void radioButtonDialog(View view)
    {
        
    }

    public void checkBoxDialog(View view)
    {

    }

    public void inputDialog(View view)
    {

    }
}
