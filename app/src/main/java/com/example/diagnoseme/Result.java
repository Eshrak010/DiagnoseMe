package com.example.diagnoseme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Result extends AppCompatActivity {

    private TextView ResultText;
    private RelativeLayout mailU;
    private RelativeLayout sendmsgD;
    private ProgressBar progBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ResultText=findViewById(R.id.textResult);
        progBar = findViewById(R.id.progressBar);

        mailU=findViewById(R.id.mail);
        sendmsgD=findViewById(R.id.sendmsg);


        // Update the ProgressBar


        sendmsgD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Result.this,Home.class);
                i.putExtra("OpenFragment", "SpecialistFragment"); // Passing the fragment name to open
                startActivity(i);
            }
        });



        Intent intent = getIntent();
        String pdfFilePath = intent.getStringExtra("PDFFilePath");
        String emailUser=intent.getStringExtra("email");
        mailU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String pdfUrl = pdfFilePath;
                    openPdf(pdfUrl);


        }
        });

        int totalScore = getIntent().getIntExtra("TotalScore", 0);
        int progress = calculateProgress(totalScore);
        progBar.setProgress(progress);

        if (totalScore==4){
            ResultText.setText("You're in good shape");
        } else if (totalScore>4 && totalScore<=9) {
            ResultText.setText("Your health is unstable");
        }else{
            ResultText.setText("You're in bad shape");
        }

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
                Toast.makeText(Result.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Result.this, "Failed to generate PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private int calculateProgress(int totalScore) {
        // Assuming the max score is 100, adjust this logic based on your scoring system
        int maxScore = 100;
        return (totalScore * 100) / maxScore;
    }
}