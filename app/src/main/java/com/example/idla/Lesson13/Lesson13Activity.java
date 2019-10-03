package com.example.idla.Lesson13;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Lesson13Activity extends AppCompatActivity
{
    EditText editTextEmail;
    EditText editTextPassword;
    TextView textViewResult;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13);

        editTextEmail = findViewById(R.id.editText5);
        editTextPassword = findViewById(R.id.editText10);
        textViewResult = findViewById(R.id.textView12);
        progressBar = findViewById(R.id.progressBar3);
    }

    public void ok(View view)
    {
        View viewFocus = this.getCurrentFocus();
        if (viewFocus != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(viewFocus.getWindowToken(), 0);
        }

        progressBar.setVisibility(View.VISIBLE);
        callPOST("https://reqres.in/api/register");

//        callGET("https://reqres.in/api/users/2");

        //官方的範例會閃退= =
//        String result = "";
//        try {
//            result = run("https://reqres.in/api/users/2");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.d("MF",result);
    }

    OkHttpClient client = new OkHttpClient();

    void callPOST(String url)
    {
        FormBody body = new FormBody.Builder()
                .add("email", String.valueOf(editTextEmail.getText()))
                .add("password", String.valueOf(editTextPassword.getText()))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback()
        {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
            {
                final String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewResult.setText(result);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e)
            {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewResult.setText("failure");
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
    }

    void callGET(String url)
    {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback()
        {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
            {
                String result = response.body().string();
                Log.d("MF", result);
            }
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e)
            {

                Log.d("MF","OkHttp failure");
            }
        });
    }

    String run(String url) throws IOException
    {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
        //加這段就build不過
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }

}
