    package com.example.diagnoseme;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;

    import android.app.Dialog;
    import android.content.Intent;
    import android.graphics.Color;
    import android.graphics.drawable.ColorDrawable;
    import android.os.Bundle;
    import android.text.method.HideReturnsTransformationMethod;
    import android.text.method.PasswordTransformationMethod;
    import android.util.Log;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.Window;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.RelativeLayout;
    import android.widget.TextView;
    import android.widget.Toast;

    import retrofit.Call;
    import retrofit.Callback;
    import retrofit.GsonConverterFactory;
    import retrofit.Response;
    import retrofit.Retrofit;

    public class SignUp extends AppCompatActivity {

        private boolean isPasswordVisible;
        private ImageButton imageButtonTogglePassword;

        private EditText username_add,email_add,password_add;
        private Button btnAddUser;
        private CheckBox check;
        private TextView SignInText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            imageButtonTogglePassword=findViewById(R.id.imageButtonTogglePassword);
            imageButtonTogglePassword.setOnClickListener(v -> togglePasswordVisibility());

            username_add=findViewById(R.id.surname);
        email_add=findViewById(R.id.email);
        password_add=findViewById(R.id.editTextPassword);
        btnAddUser=findViewById(R.id.buttonSignIn);
        check=findViewById(R.id.checkCondition);
        SignInText=findViewById(R.id.textSignIn);
        SignInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignUp.this,SignIn.class);
                startActivity(i);
            }
        });
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check.isChecked()) {
                    // Checkbox is checked, call your add() function
                    addUser();

                } else {
                    // Checkbox is unchecked, show a toast
                    Toast.makeText(getApplicationContext(), "Please agree to our terms", Toast.LENGTH_SHORT).show();
                }
            }
        });


        }

        private void addUser() {
            String URL = "http://192.168.1.6:80/";

            String userName = username_add.getText().toString().trim();
            String userEmail = email_add.getText().toString().trim();
            String userPassword = password_add.getText().toString().trim();

            // Use Retrofit to send the user data to the server
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiHandler api = retrofit.create(ApiHandler.class);
            Call<User> addUserCall = api.insertUser(userName,userEmail,userPassword);

            addUserCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Response<User> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        Toast.makeText(SignUp.this,"user added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUp.this, Home.class);
                        int userId = response.body().getId();
                        intent.putExtra("userId",userId);
                        intent.putExtra("email",userEmail);




                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                        LayoutInflater inflater = getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.custom_dialog_welcome, null);
                        builder.setView(dialogView);
                        Button continueButton = dialogView.findViewById(R.id.dialog_button);
                        AlertDialog dialog = builder.create();

                        continueButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Call your addUser method
                                startActivity(intent);

                                dialog.dismiss(); // Dismiss the dialog after the action
                            }
                        });

                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // For a transparent background
                        dialog.show();






/*
                       AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                        LayoutInflater inflater = getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.custom_dialog_thank_you, null);
                        builder.setView(dialogView);

                        AlertDialog dialog = builder.create();

                        Button continueButton = dialogView.findViewById(R.id.customButton);
                        continueButton.setOnClickListener(v -> {
                            startActivity(intent);
                            dialog.dismiss(); // Dismiss the dialog
                        });

                        dialog.show();


*/

                        //showCustomAlertDialog();
                     //   finish();
                    }else {
                        // Log the response body to see what the server returned
                        Log.e("Server Response", response.errorBody().toString());
                        // Handle the error
                        Toast.makeText(SignUp.this, "Failed: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    // Handle failure
                    Toast.makeText(SignUp.this, "Failed: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

     /*     private void showCustomAlertDialog() {

        }
          AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog_thank_you, null);
            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            Button continueButton = dialogView.findViewById(R.id.customButton);
            continueButton.setOnClickListener(v -> {
                // Handle continue button click
                dialog.dismiss(); // Dismiss the dialog
            });

            dialog.show();
        }*/

        private void togglePasswordVisibility() {
            if (isPasswordVisible) {
                // Hide the password
                password_add.setTransformationMethod(PasswordTransformationMethod.getInstance());
                imageButtonTogglePassword.setImageResource(R.drawable.eye); // replace with your 'eye' icon
            } else {
                // Show the password
                password_add.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                imageButtonTogglePassword.setImageResource(R.drawable.eyeinvisible); // replace with your 'eye off' icon
            }
            isPasswordVisible = !isPasswordVisible;
            password_add.setSelection(password_add.getText().length()); // Move cursor to the end
        }
    }