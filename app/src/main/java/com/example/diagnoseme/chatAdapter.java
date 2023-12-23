package com.example.diagnoseme;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.ViewHolder> {
    private List<ChatMessage> messages;

    public chatAdapter(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public int getItemViewType(int position) {
        // Return the view type (0 for outgoing, 1 for incoming) based on the message type
        ChatMessage message = messages.get(position);
        return message.getMessageType() == ChatMessage.MessageType.OUTGOING ? 0 : 1;
    }

    @NonNull
    @Override
    public chatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        // Inflate different layouts for incoming and outgoing messages
        if (viewType == ChatMessage.MessageType.INCOMING.ordinal()) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_bubble_incoming, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_bubble_outgoing, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatAdapter.ViewHolder holder, int position) {
        ChatMessage message = messages.get(position);

        // Set the message text
        holder.messageTextView.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textViewMessage);
        }
    }
}
