package com.example.idla;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class IDLAWidget extends AppWidgetProvider
{
    AppWidgetManager currentAppWidgetManager;
    static RemoteViews remoteView;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId)
    {
        // Construct the RemoteViews object
        remoteView = new RemoteViews(context.getPackageName(), com.example.idla.R.layout.idlawidget);

//        CharSequence widgetText = context.getString(com.example.idla.R.string.appwidget_text);
//        remoteView.setTextViewText(com.example.idla.R.id.appwidget_text, widgetText);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,new Intent().setAction("" + appWidgetId),0);
        remoteView.setOnClickPendingIntent(R.id.appwidget_btn,pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, remoteView);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        currentAppWidgetManager = appWidgetManager;
        Log.d("MF❤️","APP Widget onEnabled");

        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds)
        {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context)
    {
        // Enter relevant functionality for when the first widget is created
        Log.d("MF❤️","APP Widget onEnabled");
    }

    @Override
    public void onDisabled(Context context)
    {
        // Enter relevant functionality for when the last widget is disabled
        Log.d("MF❤️","APP Widget onDisabled");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        super.onDeleted(context, appWidgetIds);
        Log.d("MF❤️","APP Widget onDeleted");
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        Log.d("MF❤️","APP Widget onReceive");

        if (remoteView == null)
        {
            return;
        }

        CharSequence widgetText = context.getString(R.string.appwidget_text_new);
        remoteView.setTextViewText(R.id.appwidget_btn, widgetText);

        currentAppWidgetManager.updateAppWidget(Integer.parseInt(intent.getAction()),remoteView);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds)
    {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        Log.d("MF❤️","APP Widget onRestored");
    }
}

