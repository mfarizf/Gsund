package com.example.gsund.utils;

import android.app.AlarmManager;
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
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.gsund.R;
import com.example.gsund.ui.main.MainActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.example.gsund.R2.id.date;
import static com.example.gsund.R2.id.tag_unhandled_key_event_manager;

public class AlarmNotification extends BroadcastReceiver {
    public final   String  CHANNEL_ID = "Channel_1";
    public final   String CHANNEL_NAME = "Drink Reminder";
    public static final String TYPE_ONE_TIME = "OneTimeAlarm";
    public static final String TYPE_REPEATING = "RepeatingAlarm";
    private static final String EXTRA_MESSAGE = "Jangan Lupa Minum Ya!";
    private static final String EXTRA_TYPE = "type";
    private  final static  String TIME_FORMAT =  "HH:mm";
    private  final static  String DATE_FORMAT =  "yyyy-MM-dd";


    //for repeating corresponding
    public static final int  ID_REPEATING = 101;
    public static final int ID_ONETIME = 100;




    public void showNotification(Context context, String title, String message, int notifID){
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.logo)
                .setContentText(message)
                .setColor(ContextCompat.getColor(context,R.color.biru_langit))
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSound(alarm);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(CHANNEL_NAME);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000,1000,1000,1000});
            builder.setChannelId(CHANNEL_ID);
            Notification notification =  builder.build();
            notificationManagerCompat.createNotificationChannel(channel);

            if (notificationManagerCompat != null){
                notificationManagerCompat.notify(notifID,notification);
            }
        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
        }


    }

    @Override
    public void onReceive(Context context, Intent intent){
        String type = intent.getStringExtra(EXTRA_TYPE);
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        String title = type.equalsIgnoreCase(TYPE_ONE_TIME) ? TYPE_ONE_TIME : TYPE_REPEATING;
        int notifId = type.equalsIgnoreCase(TYPE_ONE_TIME) ? ID_ONETIME : ID_REPEATING;

        showNotification(context, title, message, notifId);
    }

    public void cancelAlarm(Context context, String type){
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,AlarmNotification.class);

        int requestCode = type.equalsIgnoreCase(TYPE_ONE_TIME)? ID_ONETIME : ID_REPEATING;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,requestCode,intent,0);

        if(am != null){
            am.cancel(pendingIntent);
        }

        Toast.makeText(context,"Notification Has Been Canceled, Return Back To Normal...", Toast.LENGTH_LONG).show();

    }

    public void setRepeatingAlarm(Context context, String type, String time, String message){

        if(isDateInvalid(time,TIME_FORMAT)) return;

        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,AlarmNotification.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.putExtra(EXTRA_TYPE,type);

        String[] timeArray = time.split(":");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE,Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND,0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,ID_REPEATING,intent,0);
        if (am != null){
            am.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
            am.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),3600*3*1000,pendingIntent);
        }

        Toast.makeText(context,"Repeating Alarm has been set up",Toast.LENGTH_LONG).show();

    }

    public void setOneTimeAlarm(Context context, String type, String date, String time, String message) {

        // Validasi inputan date dan time terlebih dahulu
        if (isDateInvalid(date, DATE_FORMAT) || isDateInvalid(time, TIME_FORMAT)) return;

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmNotification.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_TYPE, type);

        Log.e("ONE TIME", date + " " + time);
        String[] dateArray = date.split("-");
        String[] timeArray = time.split(":");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[2]));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND, 0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ID_ONETIME, intent, 0);
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }

        Toast.makeText(context, "One time alarm set up", Toast.LENGTH_SHORT).show();
    }


    public boolean isAlarmSet(Context context, String type){
        Intent  intent = new Intent(context,AlarmNotification.class);
        int requestCode = type.equalsIgnoreCase(TYPE_ONE_TIME) ? ID_ONETIME:ID_REPEATING;

        return PendingIntent.getBroadcast(context,requestCode,intent,PendingIntent.FLAG_NO_CREATE) != null;

    }

    private boolean isDateInvalid(String date, String format) {
        try {
            DateFormat df = new SimpleDateFormat(format, Locale.getDefault());
            df.setLenient(false);
            df.parse(date);
            return false;
        } catch (ParseException e) {
            return true;
        }
    }
}
