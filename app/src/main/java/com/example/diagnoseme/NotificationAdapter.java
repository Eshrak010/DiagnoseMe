package com.example.diagnoseme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationList> NotiList;

    public NotificationAdapter(List<NotificationList> notiList) {
        NotiList = notiList;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_items, parent, false);
        return new NotificationAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {
        NotificationList currentNotification=NotiList.get(position);

        holder.Notification.setText(currentNotification.getNotification());
    }

    @Override
    public int getItemCount() {
        return NotiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Notification;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Notification=itemView.findViewById(R.id.notification);
        }
    }
}
