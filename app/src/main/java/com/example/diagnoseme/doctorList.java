package com.example.diagnoseme;

public class doctorList {
    private String name;
    private int doctorImage;
    private String job;
    private String experience;
    private float rate;

    public doctorList(String name, int doctorImage, String job, String experience, float rate) {
        this.name = name;
        this.doctorImage = doctorImage;
        this.job = job;
        this.experience = experience;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(int doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
