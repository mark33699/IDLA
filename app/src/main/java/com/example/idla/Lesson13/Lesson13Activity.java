package com.example.idla.Lesson13;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Lesson13Activity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13);
    }

    public void ok(View view)
    {
        call("https://reqres.in/api/users/2");

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

    void call(String url)
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
