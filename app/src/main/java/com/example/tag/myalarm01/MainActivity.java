package com.example.tag.myalarm01;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final long WAIT_MILLISEC = 10*1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        //button1が押された時の処理
        Intent intent1 = new Intent(this,SubActivity.class);
        final PendingIntent pendingIntent1 = PendingIntent.getActivity(this,0,intent1,0);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //現在時刻からWAIT_MILLISEC秒後の時刻にアラームをセットする
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis()+WAIT_MILLISEC,pendingIntent1);
            }
        });

        //button1が押された時の処理
        Intent intent2 = new Intent(this,BcastReceiver.class);
        final PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this,0,intent2,0);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+
                                WAIT_MILLISEC,pendingIntent2);
            }
        });

    }
}
