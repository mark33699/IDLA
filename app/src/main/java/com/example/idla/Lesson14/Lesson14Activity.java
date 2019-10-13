package com.example.idla.Lesson14;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.idla.BaseActivity;
import com.example.idla.R;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Lesson14Activity extends BaseActivity
{
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson14);

        editText = findViewById(R.id.editText11);
        textView = findViewById(R.id.textView13);
    }

    public void search(View view)
    {
        callGET();
    }

    OkHttpClient client = new OkHttpClient();
    void callGET()
    {
        Request request = new Request.Builder()
                .url("https://www.omdbapi.com/?apikey=2edf5c13&type=movie&s=" + String.valueOf(editText.getText()))
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback()
        {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
            {
                String result = response.body().string();
                OMDBResult omdbResult = new Gson().fromJson(result,OMDBResult.class);

                String showResult = "";

                if (omdbResult.movieList == null)
                {
                    showResult = result;
                }
                else
                {
                    for(Movie movie: omdbResult.movieList)
                    {
                        showResult += movie.getTotalInfo();
                    }
                }

                final String finalShowResult = showResult;
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        textView.setText(finalShowResult);
                    }
                });
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e)
            {
                Log.d("MF","OkHttp failure");
            }
        });
    }
}
