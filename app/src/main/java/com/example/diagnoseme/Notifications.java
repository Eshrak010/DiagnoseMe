package com.example.diagnoseme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Notifications extends AppCompatActivity {

    ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);


        arrowBack=findViewById(R.id.arrow);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Notifications.this,Home.class);
                startActivity(i);
            }
        });
        List<NotificationList> myNotificationList= new ArrayList<>();
        RecyclerView recyclerViewReviews = findViewById(R.id.recyclerNotification);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewReviews.setLayoutManager(layoutManager);

        NotificationAdapter notificationAdapter = new NotificationAdapter(myNotificationList);
        recyclerViewReviews.setAdapter(notificationAdapter);


        NotificationList item=new NotificationList("your notification");
        NotificationList item2=new NotificationList("\n" +
                "We have send your test result to you via email.\n" +
                "Thank you for trusting our app\n");
        NotificationList item3=new NotificationList("Your appointment with Dr.Jamil is approaching");

        myNotificationList.add(item);
        myNotificationList.add(item2);
        myNotificationList.add(item3);
        notificationAdapter.notifyDataSetChanged();


    }
}