package com.example.idla;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.idla.Lesson20_22.Lesson22Activity;

/**
 * Implementation of App Widget functionality.
 */
public class IDLAWidget extends AppWidgetProvider
{

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), com.example.idla.R.layout.idlawidget);
        Intent intent = new Intent(context, Lesson22Activity.class);
        intent.putExtra("title","Lesson 20 - APP widget");
        remoteView.setOnClickPendingIntent(com.example.idla.R.id.appwidget_btn, PendingIntent.getActivity(context,0,intent,0));

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, remoteView);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Log.d("MF❤️","APP Widget onUpdate");

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        Log.d("MF❤️","APP Widget onEnabled");

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);

        if (intent.getStringExtra("message") == null)
        {
            return;
        }

        String s = "APP Widget onReceive: " + intent.getStringExtra("message");
        Log.d("MF❤️",s);
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }
}

