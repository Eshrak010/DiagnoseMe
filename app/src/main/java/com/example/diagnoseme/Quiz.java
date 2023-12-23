package com.example.diagnoseme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

public class Quiz extends AppCompatActivity {

    ImageView imagepart;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    private Button submitButton;
    private TextView quest1,quest2,quest3,quest4;
    private TextView title;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        imagepart=findViewById(R.id.imagepart);
        title=findViewById(R.id.titlePart);
        quest1=findViewById(R.id.Quest1);
        quest2=findViewById(R.id.Quest2);
        quest3=findViewById(R.id.Quest3);
        quest4=findViewById(R.id.Quest4);
        radioGroup1 = findViewById(R.id.radio1);
        radioGroup2 = findViewById(R.id.radio2);
        radioGroup3 = findViewById(R.id.radio3);
        radioGroup4 = findViewById(R.id.radio4);

        submitButton = findViewById(R.id.submitbutton);

        String bodyPart = getIntent().getStringExtra("BODY_PART");
        String email=getIntent().getStringExtra("email");

        String[] questions;
        String[][] answers;

        if (bodyPart.equals("Heart")){
            imagepart.setImageResource(R.drawable.heart);
            title.setText("Heart Quiz");



            questions = new String[]{
                    "How old are you?",
                    "Do you smoke or have a history of smoking?",
                    "Do you have high blood pressure (hypertension)?",
                    "What is your level of physical activity?"
            };

            answers = new String[][]{
                    {"Under 40", "40-59", "60 or older"},
                    {"No, I have never smoked", "Yes, I used to smoke, but I quit", "Yes, I currently smoke"},
                    {"No, my blood pressure is normal", "Yes, but it's controlled", "Yes and not well-controlled."},
                    {"I'm physically active most days of the week", "I'm somewhat active but could do more", "I'm mostly sedentary and rarely exercise"}
            };

            updateUI(questions, answers);

        }
        if (bodyPart.equals("Lungs")){
            imagepart.setImageResource(R.drawable.lungs);
            title.setText("Lungs Quiz");



            questions = new String[]{
                    "Have you ever been diagnosed with a respiratory condition (e.g., asthma, chronic bronchitis, COPD)?",
                    "Do you experience shortness of breath or difficulty breathing during physical activities?",
                    "Have you been exposed to environmental factors that may affect lung health (e.g., pollution, secondhand smoke)?",
                    "Do you have a history of frequent respiratory infections or pneumonia?"
            };

            answers = new String[][]{
                    {"No, I have never been diagnosed with a respiratory condition", "Yes, I have a diagnosed respiratory condition", "I'm not sure"},
                    {"No, I do not experience shortness of breath", "Yes, I experience shortness of breath during physical activities", "Occasionally"},
                    {"No, I have not been exposed to environmental factors affecting lung health", "Yes, I have been exposed to environmental factors", "I'm not sure"},
                    {"No, I do not have a history of frequent respiratory infections", "Yes, I have a history of frequent respiratory infections", "I'm not sure"}
            };



            updateUI(questions, answers);

        }
        if (bodyPart.equals("Kidney")){
            imagepart.setImageResource(R.drawable.kidney);
            title.setText("Kidney Quiz");


            questions = new String[]{
                    "Have you ever been diagnosed with a kidney condition (e.g., kidney disease, kidney stones)?",
                    "Do you experience pain or discomfort in the kidney area?",
                    "Have you noticed changes in your urinary habits, such as increased frequency or blood in the urine?",
                    "Do you have a history of high blood pressure or diabetes?"
            };

            answers = new String[][]{
                    {"No, I have never been diagnosed with a kidney condition", "Yes, I have a diagnosed kidney condition", "I'm not sure"},
                    {"No, I do not experience pain or discomfort in the kidney area", "Yes, I experience pain or discomfort in the kidney area", "Occasionally"},
                    {"No, I have not noticed changes in my urinary habits", "Yes, I have noticed changes in my urinary habits", "I'm not sure"},
                    {"No, I do not have a history of high blood pressure or diabetes", "Yes, I have a history of high blood pressure or diabetes", "I'm not sure"}
            };



            updateUI(questions, answers);

        }
        if (bodyPart.equals("Brain")){
            imagepart.setImageResource(R.drawable.brain);
            title.setText("Brain Quiz");

            questions = new String[]{
                    "Have you ever been diagnosed with a neurological condition (e.g., epilepsy, migraine, Parkinson's disease)?",
                    "Do you experience frequent headaches or migraines?",
                    "Have you ever had a seizure or convulsion?",
                    "Do you have a history of head injuries or concussions?"
            };

            answers = new String[][]{
                    {"No, I have never been diagnosed with a neurological condition", "Yes, I have a diagnosed neurological condition", "I'm not sure"},
                    {"No, I do not experience frequent headaches or migraines", "Yes, I experience frequent headaches or migraines", "Occasionally"},
                    {"No, I have never had a seizure or convulsion", "Yes, I have had a seizure or convulsion", "I'm not sure"},
                    {"No, I do not have a history of head injuries or concussions", "Yes, I have a history of head injuries or concussions", "I'm not sure"}
            };




            updateUI(questions, answers);

        }
        if (bodyPart.equals("Stomach")) {
            imagepart.setImageResource(R.drawable.stomach);
            title.setText("Stomach Quiz");

            questions = new String[]{
                    "Do you experience frequent heartburn or acid reflux?",
                    "Have you ever been diagnosed with a stomach or digestive disorder (e.g., gastritis, ulcer, irritable bowel syndrome)?",
                    "Do you often feel bloated or experience abdominal discomfort after meals?",
                    "Have you noticed any changes in your bowel habits, such as constipation or diarrhea?"
            };

            answers = new String[][]{
                    {"No, I do not experience frequent heartburn or acid reflux", "Yes, I experience frequent heartburn or acid reflux", "I occasionally experience heartburn"},
                    {"No, I have never been diagnosed with a stomach or digestive disorder", "Yes, I have a diagnosed stomach or digestive disorder", "I am not sure"},
                    {"No, I do not often feel bloated or experience abdominal discomfort", "Yes, I often feel bloated or experience abdominal discomfort after meals", "Occasionally"},
                    {"No, I have not noticed any changes in my bowel habits", "Yes, I have noticed changes in my bowel habits (constipation or diarrhea)", "I am not sure"}
            };
        updateUI(questions, answers);

        }
        if (bodyPart.equals("Liver")) {
            imagepart.setImageResource(R.drawable.liver);
            title.setText("Liver Quiz");

            questions = new String[]{
                    "Do you consume alcohol? If yes, how often?",
                    "Have you ever been diagnosed with liver disease or a liver-related condition?",
                    "Do you experience abdominal pain or discomfort on a regular basis?",
                    "Have you noticed any yellowing of your skin or eyes (jaundice)?"
            };

            answers = new String[][]{
                    {"No, I do not consume alcohol", "Yes, occasionally", "Yes, regularly"},
                    {"No, I have never been diagnosed with liver disease", "Yes, I have a diagnosed liver disease or condition", "Yes, I have a liver-related condition but not liver disease"},
                    {"No, I do not experience abdominal pain or discomfort", "Yes, I experience abdominal pain or discomfort regularly", "Yes, I experience occasional abdominal pain"},
                    {"No, I have not noticed any yellowing of my skin or eyes", "Yes, I have noticed yellowing of my skin or eyes", "I am not sure"}
            };

        updateUI(questions, answers);

        }
    submitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String answer1 = getSelectedAnswer(radioGroup1);
            String answer2 = getSelectedAnswer(radioGroup2);
            String answer3 = getSelectedAnswer(radioGroup3);
            String answer4 = getSelectedAnswer(radioGroup4);
            int score1 = getSelectedAnswerScore(radioGroup1);
            int score2 = getSelectedAnswerScore(radioGroup2);
            int score3 = getSelectedAnswerScore(radioGroup3);
            int score4 = getSelectedAnswerScore(radioGroup4);

            String[] answers = new String[] {answer1, answer2, answer3, answer4};

            String pdfPath = createPdf(answers);
            int totalScore = score1 + score2 + score3 + score4;
          //  openPdf(pdfPath);
            Intent intent = new Intent(Quiz.this, Result.class);
            intent.putExtra("PDFFilePath", pdfPath);
            intent.putExtra("TotalScore", totalScore);
            intent.putExtra("email",email);
            startActivity(intent);


        }
    });
    }


    private void openPdf(String filePath) {
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            Uri path = FileProvider.getUriForFile(this, "com.example.diagnoseme.fileprovider", pdfFile);
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(path, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            try {
                startActivity(pdfIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(Quiz.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Quiz.this, "Failed to generate PDF", Toast.LENGTH_SHORT).show();
        }
    }


    private int getSelectedAnswerScore(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            // Assuming the first child has a score of 1, the second child has a score of 2, etc.
            return radioGroup.indexOfChild(findViewById(selectedId)) + 1;
        }
        return 0; // Return 0 if no answer is selected
    }

    private String createPdf(String[] answers) {
        try {
            // File path for the PDF
            String filePath = getExternalFilesDir(null) + "/QuizResults.pdf";
            PdfWriter writer = new PdfWriter(filePath);

            // Initialize PDF document
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add content to the document
            document.add(new Paragraph("Quiz Results"));
            for (String answer : answers) {
                document.add(new Paragraph(answer));
            }

            // Close document
            document.close();

            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private String getSelectedAnswer(RadioGroup radioGroup) {
        // Check if a button is selected in this group
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            return selectedRadioButton.getText().toString();
        }
        return "No answer selected"; // Or handle this scenario as you see fit
    }
    private void updateUI(String[] questions, String[][] answers) {
        quest1.setText(questions[0]);
        quest2.setText(questions[1]);
        quest3.setText(questions[2]);
        quest4.setText(questions[3]);

        setAnswersToRadioGroup(answers[0], radioGroup1);
        // Set answers for the second question
        setAnswersToRadioGroup(answers[1], radioGroup2);
        // Set answers for the third question
        setAnswersToRadioGroup(answers[2], radioGroup3);
        // Set answers for the fourth question
        setAnswersToRadioGroup(answers[3], radioGroup4);

    }

    private void setAnswersToRadioGroup(String[] answerOption, RadioGroup radioGroup) {
            radioGroup.removeAllViews();


        for (int i = 0; i < answerOption.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answerOption[i]);

            // Add the RadioButton to the provided RadioGroup
            radioGroup.addView(radioButton);
        }
    }

}