package com.example.diagnoseme;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemSearchAdapter adapter;
    private List<ItemSearch> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.recyclerSearch);

        // Initialize your item list and fill it with data
        InitializeItems();

        adapter = new ItemSearchAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Handle search query if available
        if (getArguments() != null) {
            String searchQuery = getArguments().getString("searchQuery");
            if (searchQuery != null && !searchQuery.isEmpty()) {
                adapter.filter(searchQuery);
            }
        }

        adapter.setOnItemClickListener(item -> {
            Intent intent;
            switch (item.getText()) {
                case "Heart":
                    intent = new Intent(getActivity(), Quiz.class);
                    intent.putExtra("BODY_PART", "Heart");
                    startActivity(intent);
                    break;
                case "Stomach":
                    navigateToQuiz("Stomach");
                    break;
                case "Liver":
                    navigateToQuiz("Liver");
                    break;
                case "Lungs":
                    navigateToQuiz("Lungs");
                    break;
                case "Brain":
                    navigateToQuiz("Brain");
                    break;
                case "Kidney":
                    navigateToQuiz("Kidney");
                    break;
                case "Pediatric":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                    intent.putExtra("DOCTOR_NAME", "Dr. jamila");
                    startActivity(intent);
                    break;
                case "cardiologist":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                    intent.putExtra("DOCTOR_NAME", "Dr. jamil");
                    startActivity(intent);

                    break;
                case "Neurologist":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                    intent.putExtra("DOCTOR_NAME", "Dr. Mansour");
                    startActivity(intent);

                    break;
                case "Hepatologist":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                    intent.putExtra("DOCTOR_NAME", "Dr. Mlek");
                    startActivity(intent);

                    break;
                case "Nephrologist":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                        intent.putExtra("DOCTOR_NAME", "Dr. Moueez");
                    startActivity(intent);

                    break;
                case "Pulmonoligist":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                    intent.putExtra("DOCTOR_NAME", "Dr. Asma");
                    startActivity(intent);

                    break;
                case "gastroenterologist":
                    intent = new Intent(getActivity(), DoctorProfile.class);
                    intent.putExtra("DOCTOR_NAME", "Dr. Majdi");
                    startActivity(intent);
                    break;

                default:
                  //
                    break;
            }



            // Handle the item click event, navigate to a new page
        });



        return view;
    }

    private void InitializeItems(){
        itemList = new ArrayList<>();
        itemList.add(new ItemSearch(R.drawable.heart, "Heart "));
        itemList.add(new ItemSearch(R.drawable.jamila, "Pediatric"));
        itemList.add(new ItemSearch(R.drawable.jamil, "cardiologist"));
        itemList.add(new ItemSearch(R.drawable.mansour, "Neurologist"));
        itemList.add(new ItemSearch(R.drawable.kidney, "Kidney"));
        itemList.add(new ItemSearch(R.drawable.liver, "Liver"));
        itemList.add(new ItemSearch(R.drawable.tbiba, "Hepatologist"));
        itemList.add(new ItemSearch(R.drawable.moueez, "Nephrologist"));
        itemList.add(new ItemSearch(R.drawable.asma, "Pulmonologist"));
        itemList.add(new ItemSearch(R.drawable.lungs, "Lungs "));
        itemList.add(new ItemSearch(R.drawable.brain, "Brain "));
        itemList.add(new ItemSearch(R.drawable.stomach, "Stomach "));
        itemList.add(new ItemSearch(R.drawable.moueez, "gastroenterologist"));
    }
    private void navigateToQuiz(String bodyPart) {
        // Create an Intent to navigate to the Quiz activity
        Intent intent = new Intent(getActivity(), Quiz.class);

        // Retrieve the email from the fragment's arguments
        Bundle bundle = getArguments();

        // Pass the selected body part and email as extras to the Quiz activity
        intent.putExtra("BODY_PART", bodyPart);

        // Start the Quiz activity
        startActivity(intent);
    }

}