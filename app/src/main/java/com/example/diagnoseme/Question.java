package com.example.diagnoseme;
import java.util.List;

public class Question {
    private String text;
    private String category;
    private List<String> answers;

    public Question(String text, String category, List<String> answers) {
        this.text = text;
        this.category = category;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getAnswers() {
        return answers;
    }

}
