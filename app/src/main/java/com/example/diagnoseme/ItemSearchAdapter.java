package com.example.diagnoseme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class ItemSearchAdapter extends RecyclerView.Adapter<ItemSearchAdapter.ItemViewHolder> {
    private OnItemClickListener listener;


    private List<ItemSearch> itemList;
    private List<ItemSearch> originalList; // Original list to hold all items

    public ItemSearchAdapter(List<ItemSearch> itemList) {
        this.itemList = itemList;
        this.originalList = new ArrayList<>(itemList); // Create a copy for the original list
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemSearch currentItem = itemList.get(position);
        holder.imageView.setImageResource(currentItem.getImageId());
        holder.textView.setText(currentItem.getText());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_text);
        }
    }

    public void filter(String text) {
        List<ItemSearch> filteredList = new ArrayList<>();
        for (ItemSearch item : originalList) {
            if (item.getText().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))) {
                filteredList.add(item);
            }
        }
        itemList.clear();
        itemList.addAll(filteredList);
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
