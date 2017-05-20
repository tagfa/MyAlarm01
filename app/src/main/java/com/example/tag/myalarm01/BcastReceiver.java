package com.example.tag.myalarm01;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by tag on 2017/05/20.
 */

public class BcastReceiver extends BroadcastReceiver {

    private static final int MY_NOTIFICATION_ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"BcastReceiver実行",Toast.LENGTH_LONG);

        Notification.Builder builder = new Notification.Builder(context)
                .setDefaults(Notification.DEFAULT_VIBRATE|Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Hello World")
                .setContentText("SubActivityを実行します");

        Intent result = new Intent(context,SubActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(context,0,result,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(MY_NOTIFICATION_ID,builder.build());
    }
}
