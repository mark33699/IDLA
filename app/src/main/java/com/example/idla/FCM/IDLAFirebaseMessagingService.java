package com.example.idla.FCM;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.idla.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class IDLAFirebaseMessagingService extends FirebaseMessagingService
{
    public IDLAFirebaseMessagingService() { }

    @Override
    public void onNewToken(String s)
    {
        super.onNewToken(s);

//        sendRegistrationToServer(token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("MF❤️", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0)
        {
            Log.d("MF❤️", "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true)
            {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                scheduleJob();
            }
            else
            {
                // Handle message within 10 seconds
//                handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null)
        {
            Log.d("MF❤️", "Message Notification Body: " + remoteMessage.getNotification().getBody());

            RemoteMessage.Notification remoteNotif = remoteMessage.getNotification();

            Notification notif = new NotificationCompat.Builder(this,"NotificationChannelID")
                    .setSmallIcon(R.drawable.chess_knight)
                    .setContentTitle(remoteNotif.getTitle())
                    .setContentText(remoteNotif.getBody())
                    .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(999,notif);

            broadcast(remoteNotif.getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private void broadcast(String message)
    {
        Intent intent = new Intent("FCM");
        intent.putExtra("notifi",message);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
