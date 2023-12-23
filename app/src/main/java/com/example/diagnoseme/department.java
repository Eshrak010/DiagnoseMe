package com.example.diagnoseme;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link department#newInstance} factory method to
 * create an instance of this fragment.
 */
public class department extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public department() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment department.
     */
    // TODO: Rename and change types and number of parameters
    public static department newInstance(String param1, String param2) {
        department fragment = new department();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_department, container, false);

        // Find the linear layouts for different body parts
        LinearLayout heartLayout = view.findViewById(R.id.lineartHeart);
        LinearLayout lungLayout = view.findViewById(R.id.linearLungs);
        LinearLayout brainLayout = view.findViewById(R.id.lineartBrain);
        LinearLayout stomachLayout = view.findViewById(R.id.linearStomach);
        LinearLayout liverLayout = view.findViewById(R.id.lineartLiver);
        LinearLayout kidneyLayout = view.findViewById(R.id.lineartkidney);

        heartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the quiz page for the heart
                navigateToQuiz("Heart");
            }
        });

        lungLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the quiz page for the lung
                navigateToQuiz("Lungs");
            }
        });


        liverLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the quiz page for the lung
                navigateToQuiz("Liver");
            }
        });



        stomachLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the quiz page for the lung
                navigateToQuiz("Stomach");
            }
        });

        kidneyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the quiz page for the lung
                navigateToQuiz("Kidney");
            }
        });

        brainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the quiz page for the lung
                navigateToQuiz("Brain");
            }
        });
        return view;
    }

    private void navigateToQuiz(String bodyPart) {
        // Create an Intent to navigate to the Quiz activity
        Intent intent = new Intent(getActivity(), Quiz.class);

        // Retrieve the email from the fragment's arguments
        Bundle bundle = getArguments();
        String email = "";
        if (bundle != null) {
            email = bundle.getString("email", ""); // Use a default value if necessary
        }

        // Pass the selected body part and email as extras to the Quiz activity
        intent.putExtra("BODY_PART", bodyPart);
        intent.putExtra("email", email);

        // Start the Quiz activity
        startActivity(intent);
    }


}