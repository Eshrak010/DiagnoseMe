package com.example.diagnoseme;

public class QuizQuestion {


    private String question;
    private String option1;
    private String option2;
    private String option3;

    public QuizQuestion(String question, String option1, String option2, String option3) {

        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }



    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }
}
