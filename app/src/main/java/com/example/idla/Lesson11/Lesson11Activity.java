package com.example.idla.Lesson11;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idla.BaseActivity;
import com.example.idla.R;

import java.util.ArrayList;

public class Lesson11Activity extends BaseActivity
{
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson11);

        recyclerView = findViewById(R.id.recycleView_staff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//決定要列表或格子
        recyclerView.setAdapter(new Lesson11Adapter(new ArrayList()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//分隔線
    }

    public void reload(View view)
    {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            String bio = "";
            for (int j = 0; j < i; j++)
            {
                bio = bio + "\n";
            }
            arrayList.add(new Staff("小明","複製人",bio));
        }
        recyclerView.setAdapter(new Lesson11Adapter(arrayList));
    }
}
