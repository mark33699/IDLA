package com.example.idla.Lesson08;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson08Activity extends AppCompatActivity {

    private Boolean isAndroidOnItemSelected = true;

    private Spinner spinnerType;
    private Spinner spinnerConstellation;
    private List listSubConstellation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson08);

        spinnerType = findViewById(R.id.spinner);
        spinnerConstellation = findViewById(R.id.spinner2);
        spinnerConstellation.setPrompt("請選擇！");//無效

        final ArrayList arrayList = new ArrayList<List>();
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_water)));
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_fire)));
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_air)));
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_earth)));
        //List list = Arrays.asList(getResources().getStringArray(R.array.constellation_total));//這樣會變成一維陣列...

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { //就算人都沒點也會先跑一次...

                if (isAndroidOnItemSelected)
                {
                    isAndroidOnItemSelected = false;
                }
                else
                {
                    if(i == 0)
                    {
//                        listSubConstellation = null;//無效
//                        listSubConstellation.removeAll(listSubConstellation);//會閃
                        ArrayList array = new ArrayList();
                        ArrayAdapter arrayAdapter = new ArrayAdapter(Lesson08Activity.this, R.layout.support_simple_spinner_dropdown_item,array);
                        spinnerConstellation.setAdapter(arrayAdapter);
                    }
                    else
                    {
                        listSubConstellation = (List) arrayList.get(i - 1);//為什麼我34行已經宣告是List了還要轉？
                        ArrayAdapter arrayAdapter = new ArrayAdapter(Lesson08Activity.this, R.layout.support_simple_spinner_dropdown_item, listSubConstellation);
                        spinnerConstellation.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //在這邊設提示也無效
                //最好我設個提示還要自訂Adapter...
                //https://pcwiki.pixnet.net/blog/post/97702431-android-spinner-%E4%B8%80%E9%96%8B%E5%A7%8B-%E9%A0%90%E8%A8%AD-%E9%BB%98%E8%AA%8D-%E6%9C%AA%E9%81%B8%E5%8F%96%E4%BB%BB%E4%BD%95%E9%81%B8
            }
        });
    }
}
