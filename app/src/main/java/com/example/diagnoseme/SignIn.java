package com.example.diagnoseme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class SignIn extends AppCompatActivity {
    private boolean isPasswordVisible;

    private EditText Usr_email,Usr_password;
    private Button btnSignIn;
    private TextView SignUpText;
    private ImageButton imageButtonTogglePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        imageButtonTogglePassword=findViewById(R.id.imageButtonTogglePassword);
        imageButtonTogglePassword.setOnClickListener(v -> togglePasswordVisibility());
        Usr_email=findViewById(R.id.editTextEmail);
        Usr_password=findViewById(R.id.editTextPassword);
        btnSignIn=findViewById(R.id.buttonSignIn);
        SignUpText=findViewById(R.id.textSignUp);

        SignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignIn.this,SignUp.class);
                startActivity(i);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser();
            }
        });


    }

    private void signInUser() {
        String URL = "http://192.168.1.6:80/";

        String email = Usr_email.getText().toString().trim();
        String password = Usr_password.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiHandler apiService = retrofit.create(ApiHandler.class);
        Call<User> signInCall = apiService.signInUser(email, password);

        signInCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    // Sign-in successful, handle the response
                    User user = response.body();
                    int userId=response.body().getId();
                    Intent i=new Intent(SignIn.this,Home.class);
                    i.putExtra("email", email);
                    i.putExtra("userId",userId);
                    startActivity(i);
                    finish();

                    // Do something with the user data
                } else {
                    // Sign-in failed, handle the error
                    Toast.makeText(SignIn.this, "Sign-in failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(SignIn.this, "Failed: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Hide the password
            Usr_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            imageButtonTogglePassword.setImageResource(R.drawable.eye); // replace with your 'eye' icon
        } else {
            // Show the password
            Usr_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            imageButtonTogglePassword.setImageResource(R.drawable.eyeinvisible); // replace with your 'eye off' icon
        }
        isPasswordVisible = !isPasswordVisible;
        Usr_password.setSelection(Usr_password.getText().length()); // Move cursor to the end
    }
}