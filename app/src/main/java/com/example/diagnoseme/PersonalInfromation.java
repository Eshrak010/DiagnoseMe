package com.example.diagnoseme;

import android.widget.ImageView;
import android.widget.RatingBar;

public class PersonalInfromation {
    private String name;
    private int personalImage;

    private float rate;
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalImage() {
        return personalImage;
    }

    public void setPersonalImage(int personalImage) {
        this.personalImage = personalImage;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PersonalInfromation(String name, int personalImage, float rate, String comment) {
        this.name = name;
        this.personalImage = personalImage;
        this.rate = rate;
        this.comment = comment;
    }

    public PersonalInfromation() {
    }
}
