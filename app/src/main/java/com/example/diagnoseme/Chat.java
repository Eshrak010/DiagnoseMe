package com.example.diagnoseme;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    private static final int FILE_REQUEST_CODE = 1;

    private ImageView fileSend;

    private ImageView arrownoline;
    private RecyclerView recyclerView;
    private chatAdapter chatAdapter;
    private List<ChatMessage> messageList;
    private ShapeableImageView docPic;
    private TextView docName;

    private ImageButton send;
    private EditText talkingtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        arrownoline=findViewById(R.id.arrownoline);
        String doctorName=getIntent().getStringExtra("docName");
        docPic=findViewById(R.id.deocpic);
        docName=findViewById(R.id.docname);

        fileSend=findViewById(R.id.imageButtoncamera);

        fileSend.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*"); // Allow any file type
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            try {
                startActivityForResult(Intent.createChooser(intent, "Select a file"), FILE_REQUEST_CODE);
            } catch (android.content.ActivityNotFoundException ex) {
                // Handle the error if no file chooser is available
                Toast.makeText(this, "Please install a file manager.", Toast.LENGTH_SHORT).show();
            }
        });
        arrownoline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Chat.this,Home.class);
                startActivity(i);
            }
        });
        switch (doctorName) {
            case "Dr. Jamila":
                docPic.setImageResource(R.drawable.jamila);
                docName.setText("Dr. Jamila");
                break;
            case "Dr. Jamil":
                docPic.setImageResource(R.drawable.jamil);
                docName.setText("Dr. Jamil");
                break;
            case "Dr. Malek":
                docPic.setImageResource(R.drawable.tbiba);
                docName.setText("Dr. Malek");
                break;
            case "Dr. Moueez":
                docPic.setImageResource(R.drawable.moueez);
                docName.setText("Dr. Moueez");
                break;
            case "Dr. Asma":
                docPic.setImageResource(R.drawable.asma);
                docName.setText("Dr. Asma");
                break;
            case "Dr. Majdi":
                docPic.setImageResource(R.drawable.majid);
                docName.setText("Dr. Majdi");
                break;
            case "Dr. Mansour":
                docPic.setImageResource(R.drawable.mansour);
                docName.setText("Dr. Majdi");
                break;


            default:
                // Optionally handle the case where no doctor name matches
                break;
        }

        talkingtext=findViewById(R.id.talkingtext);
        recyclerView = findViewById(R.id.recyclerChat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        send=findViewById(R.id.imageButtonsend);
        messageList = new ArrayList<>();
        chatAdapter = new chatAdapter(messageList);
        recyclerView.setAdapter(chatAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = talkingtext.getText().toString();
                if (!messageText.isEmpty()) {
                    ChatMessage chatMessage = new ChatMessage(messageText, ChatMessage.MessageType.OUTGOING);
                    messageList.add(chatMessage);
                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messageList.size() - 1); // Scroll to the bottom
                    talkingtext.setText(""); // Clear the input field

                }
            }
        });

        ChatMessage message2=new ChatMessage("Hello and welcome", ChatMessage.MessageType.INCOMING);

        messageList.add(message2);

        chatAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri fileUri = data.getData();
                // Handle the file URI (e.g., upload to server or display in your app)
                // You can use fileUri.toString() to get the file path or use it directly
            }
        }
    }
}