package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn_click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click=findViewById(R.id.btnclick);



        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {

            NotificationChannel channel = new NotificationChannel("MY NOTIFICATION","MY NOTIFICATION",
                    NotificationManager.IMPORTANCE_DEFAULT);


            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);






        }
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickme();

            }
        });

    }

    private void clickme() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("its a simple Notification")
                .setContentText("here we can put text notification ")
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1,builder.build());


    }
}