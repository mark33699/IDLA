package com.example.idla.Lesson08;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Lesson08Activity extends AppCompatActivity {

    private Boolean isAndroidOnItemSelected = true;

    private Spinner spinnerType;
    private Spinner spinnerConstellation;

    private DatePickerDialog datePickerDialog;

    private EditText editTextDay;
    private EditText editTextTime;

    private List listSubConstellation;
    private ArrayList arrayList;
    private ArrayList arrayListColor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson08);

        createArrayData();

        spinnerConstellation = findViewById(R.id.spinner2);
        spinnerConstellation.setPrompt("請選擇！");//無效
        spinnerType = findViewById(R.id.spinner);
        editTextDay = findViewById(R.id.editText8);
        editTextTime = findViewById(R.id.editText9);

        editTextDay.setOnFocusChangeListener(createFocusChangeListener());
        editTextDay.setOnClickListener(createClickListener());
        editTextTime.setOnFocusChangeListener(createFocusChangeListener());
        editTextTime.setOnClickListener(createClickListener());

        spinnerTypeOnItemSelect();
    }

    private View.OnFocusChangeListener createFocusChangeListener()
    {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocuing) {

                if(isFocuing)
                {
                    if (view == editTextDay)
                    {
                        showDatePicker();
                    }
                    else if (view == editTextTime)
                    {
                        showTimePicker();
                    }
                }
            }
        };
        return onFocusChangeListener;
    }

    private View.OnClickListener createClickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view == editTextDay)
                {
                    showDatePicker();
                }
                else if (view == editTextTime)
                {
                    showTimePicker();
                }
            }
        };
        return onClickListener;
    }

    private void showDatePicker()
    {
        Calendar c = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                editTextDay.setText(i + "/" + i1 + "/" + i2);
            }
        };
        new DatePickerDialog(this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void showTimePicker()
    {
        Calendar c = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                editTextTime.setText(i + ":" + i1);
            }
        };
        new TimePickerDialog(this,t,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false)
                .show();
    }

    private void spinnerTypeOnItemSelect()
    {
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

                    spinnerType.setBackgroundColor((Integer) arrayListColor.get(i));
                    spinnerConstellation.setBackgroundColor((Integer) arrayListColor.get(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //在這邊設提示也無效
                //最好我設個提示還要自訂Adapter...
            }
        });
    }

    private void createArrayData()
    {
        arrayList = new ArrayList<List>();
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_water)));
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_fire)));
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_air)));
        arrayList.add(Arrays.asList(getResources().getStringArray(R.array.constellation_earth)));
        //List list = Arrays.asList(getResources().getStringArray(R.array.constellation_total));//這樣會變成一維陣列...

        arrayListColor = new ArrayList();
        arrayListColor.add(getResources().getColor(R.color.gray));
        arrayListColor.add(getResources().getColor(R.color.blue));
        arrayListColor.add(getResources().getColor(R.color.red));
        arrayListColor.add(getResources().getColor(R.color.green));
        arrayListColor.add(getResources().getColor(R.color.yellow));
    }
}
