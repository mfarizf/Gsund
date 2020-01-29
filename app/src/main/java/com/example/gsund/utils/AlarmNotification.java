package com.example.gsund.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.gsund.R;
import com.example.gsund.ui.main.MainActivity;

public class AlarmNotification extends BroadcastReceiver {
    public final   String  CHANNEL_ID = "Channel_1";
    public final   String CHANNEL_NAME = "Drink Reminder";




    public void showNotification(Context context, String title, String message, int notifID){


        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);


        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.appintro_indicator_dot_grey)
                .setContentText(message)
                .setColor(ContextCompat.getColor(context,R.color.biru_langit))
                .setStyle(new NotificationCompat.BigPictureStyle())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSound(alarm);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_NAME);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000,1000,1000,1000});
            builder.setChannelId(CHANNEL_ID);
            Notification notification =  builder.build();
            notificationManagerCompat.createNotificationChannel(channel);

            if (notificationManagerCompat != null){
                notificationManagerCompat.notify(notifID,notification);
            }
        }


    }

    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
