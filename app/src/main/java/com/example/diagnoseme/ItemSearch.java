package com.example.diagnoseme;

public class ItemSearch {
    private int imageId;
    private String text;

    public ItemSearch(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}
