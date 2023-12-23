package com.example.diagnoseme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;

public class Home extends AppCompatActivity {
    private String userEmail;

    private ShapeableImageView profilPic;
    private TextView User_Name;

    private SearchView search;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        search=findViewById(R.id.search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Fragment searchResultsFragment = new SearchFragment();
                Bundle bundle = new Bundle();
                bundle.putString("searchQuery", newText);
                searchResultsFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.changeableFragment, searchResultsFragment)
                        .commit();

                return true;
            }
        });




        User_Name=findViewById(R.id.usernameHome);
        String EmailGetting = getIntent().getStringExtra("email");

        String EmailBack=getIntent().getStringExtra("emailBack");
        int UserId=getIntent().getIntExtra("userId",-1);
        profilPic=findViewById(R.id.profilepicturehome);
        profilPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Home.this, Profil.class);
                in.putExtra("EmaikIfBack",EmailBack);
                in.putExtra("emailUser",EmailGetting);
                in.putExtra("userId",UserId);
                startActivity(in);
            }
        });
        BottomNavigationView bottomNavView = findViewById(R.id.bottomNavView);
        String fragmentToOpen = getIntent().getStringExtra("OpenFragment");
        if (fragmentToOpen != null && fragmentToOpen.equals("SpecialistFragment")) {
            displayFragment(new SpecialistFragment());
            bottomNavView.setSelectedItemId(R.id.specialist);
        } else {
            // Default fragment or any other logic
        }


        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment myFrag = new HomeFragment();
                if (item.getItemId()==R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.changeableFragment, new HomeFragment()).commit();
                }
                if (item.getItemId() == R.id.home) {
                    myFrag = new HomeFragment();
               //     bottomNavView.setSelectedItemId(R.id.home);
                } else if (item.getItemId() == R.id.department) {
                    myFrag = new department();
                    Bundle bundle = new Bundle();
                    bundle.putString("email", EmailGetting);
                    myFrag.setArguments(bundle);
                } else if (item.getItemId() == R.id.specialist) {
                    myFrag = new SpecialistFragment();
                } else if (item.getItemId() == R.id.notifications) {
                    Intent i=new Intent(Home.this,Notifications.class);
                    startActivity(i);
                }

                if (myFrag != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.changeableFragment, myFrag).commit();
                    return true;
                }

                return false;
            }
        });

    }
    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.changeableFragment, fragment) // Replace with your FrameLayout container ID
                .commit();
    }
}