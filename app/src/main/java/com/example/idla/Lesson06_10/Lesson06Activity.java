package com.example.idla.Lesson06_10;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.idla.BaseActivity;
import com.example.idla.R;

import java.util.ArrayList;

public class Lesson06Activity extends BaseActivity
{
    static int kDefaultDay = 1;
    private int theDay;
    private ArrayList<String> theWeathers;

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
        final String[] seasons = {"春天","夏天","秋天","冬天"};

        Dialog dialog = new AlertDialog.Builder(this)

            .setTitle("請問您喜歡哪個季節？")
//          .setMessage("隨便") 加這行選項就都不見
            .setItems(seasons, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(Lesson06Activity.this,"好巧喔❤️我也好愛" + seasons[i], Toast.LENGTH_LONG).show();
                }
            }).create();

        dialog.show();
    }

    public void radioButtonDialog(View view)
    {
        theDay = kDefaultDay;
        final String[] threeDays = {"昨天","今天","明天"};

        Dialog dialog = new AlertDialog.Builder(this)

            .setTitle("請問您活在哪一天？")
//          .setMessage("隨便") //一樣會壞掉
            .setSingleChoiceItems(threeDays, kDefaultDay, /*預設值*/ new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    theDay = i;
                }
            })
            .setPositiveButton("就是這天", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) { //這邊i會給-1, 要自己存...
                    switch (theDay)
                    {
                        case 0:
                        {
                            Toast.makeText(Lesson06Activity.this,"您還活在過去", Toast.LENGTH_LONG).show();
                            break;
                        }
                        case 1:
                        {
                            Toast.makeText(Lesson06Activity.this,"您活在當下", Toast.LENGTH_LONG).show();
                            break;
                        }
                        case 2:
                        {
                            Toast.makeText(Lesson06Activity.this,"您已經活到未來", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }
                }
            })
            .create();

        dialog.show();
    }

    public void checkBoxDialog(View view)
    {
        final String[] weathers = {"晴天","陰天","雨天","颱風天","下雪天"};
        final boolean[] defaultWeathers = {true,false,true,false,true,false,true,false,true,false,true,false};//多的就算了
        theWeathers = new ArrayList<>();

        Dialog dialog = new AlertDialog.Builder(this)

            .setTitle("請問您最喜歡哪些天氣？")
            .setMultiChoiceItems(weathers, null /*有給預設值的話, 記得資料也要處理*/, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    if (b)
                    {
                        theWeathers.add(weathers[i]);
                    }
                    else
                    {
                        theWeathers.remove(weathers[i]);
                    }
                }
            })
            .setPositiveButton("好了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String string = "";
                    for(String str: theWeathers)
                    {
                        string = string + str + "\n";
                    }
                    Toast.makeText(Lesson06Activity.this,"您選了：\n" + string, Toast.LENGTH_LONG).show();
                }
            })
            .create();

        dialog.show();
    }

    public void inputDialog(View view)
    {
        LayoutInflater layoutInflater = getLayoutInflater();
        final View viewLayout = layoutInflater.inflate(R.layout.login_layout,null);
        Dialog dialog = new AlertDialog.Builder(this)

            .setTitle("請輸入帳密")
            .setMessage("帳號abc密碼123")
            .setView(viewLayout)
            .setPositiveButton("登入", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText editTextUsr = viewLayout.findViewById(R.id.editText6);
                    EditText editTextPwd = viewLayout.findViewById(R.id.editText7);
                    String strUsr = String.valueOf(editTextUsr.getText());
                    String strPwd = String.valueOf(editTextPwd.getText());
                    if (TextUtils.equals(editTextUsr.getText(), "abc") && TextUtils.equals(editTextPwd.getText(), "123"))
//                    if (editTextUsr.getText().equals("abc") && editTextPwd.getText().equals("123"))//直接這樣不行
//                    if (strUsr.equals("abc") && strPwd.equals("123"))//要像這樣轉型
                    {
                        Toast.makeText(Lesson06Activity.this,"登入成功", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
//                        Toast.makeText(Lesson06Activity.this,"登入失敗", Toast.LENGTH_LONG).show();
                        Toast.makeText(Lesson06Activity.this,editTextUsr.getText() + "\n" + editTextPwd.getText(), Toast.LENGTH_LONG).show();
                    }
                }
            })
            .setNegativeButton("放棄",null)
            .create();

        dialog.show();

    }
}
