package com.example.idla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.Lesson03.Lesson03Activity;
import com.example.idla.Lesson04.Lesson04Activity;
import com.example.idla.Lesson05.Lesson05Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView; //畫面
    private List<String> items; //資料
    private ArrayAdapter arrayAdapter; //適配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MarkFly","Hello World");

        listView = findViewById(R.id.main_listView); //取得畫面

        setupData(); //產生資料

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,items); //使用樣式跟資料產生適配器
        listView.setAdapter(arrayAdapter); //餵給listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //監聽事件(大括號裡除了實作方法, 不能寫別的東西)

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { //變數名稱不明

                switch (i) //不會整組長出來
                {
                    case 0:
                    {
                        Intent intent = new Intent(MainActivity.this, Lesson03Activity.class);//不能只寫.this
                        intent.putExtra("title","Activity");
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {
                        Intent intent = new Intent(MainActivity.this, Lesson04Activity.class);
                        intent.putExtra("title","Layout");
                        startActivity(intent);
                        break;
                    }
                    case 2:
                    {
                        Intent intent = new Intent(MainActivity.this, Lesson05Activity.class);
                        intent.putExtra("title","ConstraintLayout");
                        startActivity(intent);
                        break;
                    }
                }
            }
        });

    }

    private void setupData() {
        items = new ArrayList<>();
        items.add("Lesson 03 - Activity");
        items.add("Lesson 04 - Layout");
        items.add("Lesson 05 - ConstraintLayout");
        items.add("Lesson 06 - 必用元件");
        items.add("Lesson 07 - 常用元件");
    }
}
