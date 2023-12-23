package com.example.diagnoseme;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Profil extends AppCompatActivity {
    private String oldPassword;
    private Button deleteMe;

    private EditText Name;
    private EditText Email;
    private EditText Password;
    private Button discard;
    private Button save;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        deleteMe=findViewById(R.id.DeleteMe);
        String EmailGetting = getIntent().getStringExtra("emailUser");

        String EmailGettingBack = getIntent().getStringExtra("EmaikIfBack");

        deleteMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EmailGetting!=null) {
                    deleteUserByEmail(EmailGetting);
                }else {
                    deleteUserByEmail(EmailGettingBack);
                }
                Toast.makeText(Profil.this, "User Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Profil.this,SignIn.class);
                startActivity(i);
            }
        });



        Name = findViewById(R.id.nameP);
        Email = findViewById(R.id.emailP);
        Password = findViewById(R.id.passP);
        save=findViewById(R.id.buttonsaveprofil);
        discard=findViewById(R.id.discradButton);
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback=new Intent(Profil.this,Home.class);
                goback.putExtra("emailBack",EmailGetting);
                startActivity(goback);
            }
        });

        if(EmailGetting!=null) {
            fetchUserDetails(EmailGetting);
        }else {
            fetchUserDetails(EmailGettingBack);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedName = Name.getText().toString();
                String updatedEmail = Email.getText().toString();
                String updatedPassword = Password.getText().toString();

                updateUserDetailsByEmail(updatedEmail,updatedName, updatedPassword);
                Toast.makeText(Profil.this, "updated successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void fetchUserDetails(String email) {
        String URL = "http://192.168.1.6:80/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiHandler api = retrofit.create(ApiHandler.class);
        Call<List<User>> Addcall = api.getAllUsers();

        Addcall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response, Retrofit retrofit) {
                List<User> users = response.body();
                for (User user : users) {
                    if (user.getEmail().equals(email)) {
                        Name.setText(user.getUsername());
                        Email.setText(user.getEmail());
                        Password.setText(user.getPassword());
                        if (user.getUsername() != null) {
                            Name.setText(user.getUsername());
                        } else {
                            Log.e("API Error", "Raw response: " + response.raw().toString());
                            Log.d("Profil", "User data: " + user.toString());                        }// Note: Displaying passwords is not recommended
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(Profil.this, "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    private void updateUserDetailsByEmail(String email, String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiHandler api = retrofit.create(ApiHandler.class);
        Call<User> call = api.updateUserByEmail(email, username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    // Assuming User class can handle the JSON response
                    User userResponse = response.body();
                    if (userResponse != null ) {
                        Toast.makeText(Profil.this, "User updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Profil.this, "Update failed: ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Profil.this, "Update failed: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                //Toast.makeText(Profil.this, "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        } );
    }

    private void deleteUserByEmail(String email) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiHandler api = retrofit.create(ApiHandler.class);

        Call<User> call = api.deleteUserByEmail(email);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    // User deleted successfully
                    Toast.makeText(getApplicationContext(), "User deleted", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle failure
                    Toast.makeText(getApplicationContext(), "Failed to delete user", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // Handle complete failure (like network error)
               // Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
            });
    }


}