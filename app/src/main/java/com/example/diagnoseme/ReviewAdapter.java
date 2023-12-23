package com.example.diagnoseme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<PersonalInfromation> reviewList;

    // Constructor
    public ReviewAdapter(List<PersonalInfromation> reviewList) {
        this.reviewList = reviewList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_review_adapter, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonalInfromation currentReview = reviewList.get(position);

        holder.nameTextView.setText(currentReview.getName());
        holder.ratingBar.setRating(currentReview.getRate());
        holder.imageView.setImageResource(currentReview.getPersonalImage());
        holder.comment.setText(currentReview.getComment());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    // Implement necessary methods for RecyclerView.Adapter

    static class ViewHolder extends RecyclerView.ViewHolder {
        // Add references to views in the item layout, e.g., CardView, TextViews

        TextView nameTextView;
        RatingBar ratingBar;
        ImageView imageView;
        TextView comment;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.Personname);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageView = itemView.findViewById(R.id.PersonImage);
            comment = itemView.findViewById(R.id.comment);
        }

    }
}
