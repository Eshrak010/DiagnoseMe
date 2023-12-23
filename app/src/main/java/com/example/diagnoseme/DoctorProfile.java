package com.example.diagnoseme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DoctorProfile extends AppCompatActivity {
    private Button request;

    private LinearLayout selectedLayout = null;

    private ImageView arrowBack;

    private ShapeableImageView doctorImg;
    private TextView DoctorName;
    private TextView DoctorJob;
    private TextView Experience;
    private RatingBar rating;
    private LinearLayout LinearMon;
    private LinearLayout LinearTue;
    private LinearLayout LinearWed;
    private LinearLayout LinearThu;
    private LinearLayout LinearFri;
    private LinearLayout LinearSat;


    private TextView am8;
    private TextView am9;
    private TextView am10;
    private TextView am11;
    private TextView am12;
    private TextView am13;

    private TextView lastSelectedScheduleItem = null;
    private List<TextView> scheduleItems = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        arrowBack=findViewById(R.id.arrow);
        DoctorName=findViewById(R.id.doctorName);
        DoctorJob=findViewById(R.id.DoctorJob);
        doctorImg=findViewById(R.id.doctorImage);
        Experience=findViewById(R.id.experience);
        rating=findViewById(R.id.ratingBar);
        request=findViewById(R.id.requestShedule);

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        String doctorName = getIntent().getStringExtra("DOCTOR_NAME");
        // Use doctorName as needed, e.g., set it in a TextView
        TextView doctorNameTextView = findViewById(R.id.doctorName);
        doctorNameTextView.setText(doctorName);


        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DoctorProfile.this,Home.class);
                startActivity(i);
            }
        });

        LinearMon=findViewById(R.id.LinearMon);
        LinearTue=findViewById(R.id.LinearTue);
        LinearWed=findViewById(R.id.LinearWed);
        LinearThu=findViewById(R.id.LinearThu);
        LinearFri=findViewById(R.id.LinearFri);
        LinearSat=findViewById(R.id.LinearSat);
        am8=findViewById(R.id.am8);
        am9=findViewById(R.id.am9);
        am10=findViewById(R.id.am10);
        am11=findViewById(R.id.am11);
        am12=findViewById(R.id.am12);
        am13=findViewById(R.id.am13);

        setupDateSelection(LinearMon);
        setupDateSelection(LinearTue);
        setupDateSelection(LinearWed);
        setupDateSelection(LinearThu);
        setupDateSelection(LinearFri);
        setupDateSelection(LinearSat);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentChat=new Intent(DoctorProfile.this,Chat.class);
                        intentChat.putExtra("docName",doctorName);
                        startActivity(intentChat);
                    }
                });
            }
        });
        RecyclerView recyclerViewReviews = findViewById(R.id.ReviewScroll);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewReviews.setLayoutManager(layoutManager);


        List<PersonalInfromation> doctorSpecificReviews = DoctorReviewsProvider.getReviewsForDoctor(doctorName);


        ReviewAdapter reviewAdapter = new ReviewAdapter(doctorSpecificReviews);
        recyclerViewReviews.setAdapter(reviewAdapter);

        if (Objects.equals(doctorName, "Dr. Jamila")){
            DoctorName.setText("Dr. Jamila");
            DoctorJob.setText("pediatrician");
            Experience.setText("7 Years");
            rating.setRating(4.5f);
            doctorImg.setImageResource(R.drawable.jamila);
            Log.d("DoctorProfile", "Setting image for Dr. Jamila");



            // doctorImg,Experience,rating
        }
        if (Objects.equals(doctorName, "Dr. Jamil")){
            DoctorName.setText("Dr. Jamil");
            DoctorJob.setText("Cardiologist");
            Experience.setText("5 Years");
            rating.setRating(4f);
            doctorImg.setImageResource(R.drawable.jamil);
            // doctorImg,Experience,rating
        }
        if (Objects.equals(doctorName, "Dr. Mansour")){
            DoctorName.setText("Dr. Mansour");
            DoctorJob.setText("Neurologist");
            Experience.setText("4 Years");
            rating.setRating(4f);
            doctorImg.setImageResource(R.drawable.mansour);
            // doctorImg,Experience,rating
        }
        if (Objects.equals(doctorName, "Dr. Malek")){
            DoctorName.setText("Dr. Malek");
            DoctorJob.setText("Hepatologist");
            Experience.setText("3 Years");
            rating.setRating(4f);
            doctorImg.setImageResource(R.drawable.tbiba);
            // doctorImg,Experience,rating
        }
        if (Objects.equals(doctorName, "Dr. Moueez")){
            DoctorName.setText("Dr. Moueez");
            DoctorJob.setText("nephrologist");
            Experience.setText("3 Years");
            rating.setRating(3.5f);
            doctorImg.setImageResource(R.drawable.moueez);
            // doctorImg,Experience,rating
        }
        if (Objects.equals(doctorName, "Dr. Asma")){
            DoctorName.setText("Dr. Asma");
            DoctorJob.setText("Pulmonologist");
            Experience.setText("4 Years");
            rating.setRating(4.5f);
            doctorImg.setImageResource(R.drawable.asma);
            // doctorImg,Experience,rating
        }
        if (Objects.equals(doctorName, "Dr. Majdi")){
            DoctorName.setText("Dr. Majdi");
            DoctorJob.setText("gastroenterologist");
            Experience.setText("3 Years");
            rating.setRating(3.5f);
            doctorImg.setImageResource(R.drawable.majid);
            // doctorImg,Experience,rating
        }

        setupScheduleItems();
        setupDateSelections();
    }

    private void setupScheduleItems() {
        scheduleItems.add(am8);
        scheduleItems.add(am9);
        scheduleItems.add(am10);
        scheduleItems.add(am11);
        scheduleItems.add(am12);
        scheduleItems.add(am13);
    }

    private void randomizeScheduleColors() {
        Random random = new Random();
        for (TextView item : scheduleItems) {
            boolean isRed = random.nextBoolean();
            if (isRed) {
                item.setBackgroundResource(R.drawable.cornertimered);
                item.setClickable(false);
                item.setOnClickListener(null);
            } else {
                item.setBackgroundResource(R.drawable.cornertime); // Default white background
                item.setClickable(true);
                item.setOnClickListener(view -> onScheduleItemClick(item));
            }
        }
        // Reset the last selected item
        if (lastSelectedScheduleItem != null) {
            lastSelectedScheduleItem.setBackgroundResource(R.drawable.cornertime);
            lastSelectedScheduleItem = null;
        }
    }

    private void onScheduleItemClick(TextView item) {
        // Toggle the selection state
        if (lastSelectedScheduleItem != null && lastSelectedScheduleItem != item) {
            lastSelectedScheduleItem.setBackgroundResource(R.drawable.cornertime); // Revert to default background
        }
        if (item.isSelected()) {
            item.setBackgroundResource(R.drawable.cornertime); // Revert to default background
            item.setSelected(false);
        } else {
            item.setBackgroundResource(R.drawable.cornertimerblue); // Set to blue background
            item.setSelected(true);
        }
        lastSelectedScheduleItem = item;
    }


    private void setupDateSelections() {
        // Set up click listeners for each date LinearLayout
        // Call randomizeScheduleColors() when a date is clicked
        findViewById(R.id.LinearMon).setOnClickListener(view -> randomizeScheduleColors());
        findViewById(R.id.LinearTue).setOnClickListener(view -> randomizeScheduleColors());
        findViewById(R.id.LinearThu).setOnClickListener(view -> randomizeScheduleColors());
        findViewById(R.id.LinearFri).setOnClickListener(view -> randomizeScheduleColors());
        findViewById(R.id.LinearWed).setOnClickListener(view -> randomizeScheduleColors());
        findViewById(R.id.LinearSat).setOnClickListener(view -> randomizeScheduleColors());

        // Repeat for other date LinearLayouts
    }

    private void setupDateSelection(LinearLayout layout) {
        layout.setOnClickListener(view -> {
            if (selectedLayout != null && selectedLayout != layout) {
                selectedLayout.setSelected(false);
            }
            layout.setSelected(!layout.isSelected());


            // Trigger schedule color randomization
            randomizeScheduleColors();
        });
    }

    public static class Review {
        private String reviewerName;
        private float rating;
        private String reviewText;

        public Review(String reviewerName, float rating, String reviewText) {
            this.reviewerName = reviewerName;
            this.rating = rating;
            this.reviewText = reviewText;
        }
        // Getters
        public String getReviewerName() {
            return reviewerName;
        }

        public float getRating() {
            return rating;
        }

        public String getReviewText() {
            return reviewText;
        }
    }



}