package com.example.diagnoseme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.ViewHolder> {

    private List<doctorList> DoctorLists;
    private View.OnClickListener onItemClickListener;


    public DoctorListAdapter(List<doctorList> doctorList, View.OnClickListener onItemClickListener) {
        this.DoctorLists = doctorList;
        this.onItemClickListener = onItemClickListener;

    }


    @NonNull
    @Override
    public DoctorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerofdoctor, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListAdapter.ViewHolder holder, int position) {
        doctorList doctor= DoctorLists.get(position);
        holder.Name.setText(doctor.getName());
        holder.ratingBar.setRating(doctor.getRate());
        holder.imageView.setImageResource(doctor.getDoctorImage());
        holder.job.setText(doctor.getJob());
        holder.experience.setText(doctor.getExperience());
        holder.itemView.setTag(doctor.getName());
        holder.itemView.setOnClickListener(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return DoctorLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // Add references to views in the item layout, e.g., CardView, TextViews

        TextView Name;
        RatingBar ratingBar;
        ImageView imageView;
        TextView job;
        TextView experience;
        ViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.doctorName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageView = itemView.findViewById(R.id.doctorImage);
            experience = itemView.findViewById(R.id.experience);
            job=itemView.findViewById(R.id.DoctorJob);
        }

    }
}
