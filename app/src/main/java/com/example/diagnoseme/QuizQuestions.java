package com.example.diagnoseme;


import java.util.ArrayList;
import java.util.List;

public class QuizQuestions {

    private List<QuizQuestion> questions;

    public QuizQuestions() {
        questions = new ArrayList<>();
    }

    public void addQuestion(String question, String option1, String option2, String option3) {
        questions.add(new QuizQuestion(question, option1, option2, option3));
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }
}