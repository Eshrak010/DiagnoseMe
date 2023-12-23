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

public class SpecialistFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_specialist, container, false);

        // Get the RecyclerView from the layout
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerdoctorscards);

        // Create a list of Specialist objects (replace this with your actual data)
        List<doctorList> specialistList = createSpecialistList();


        // Create and set the adapter
        DoctorListAdapter adapter = new DoctorListAdapter(specialistList, view -> {
            String doctorName = (String) view.getTag();
            Intent intent = new Intent(getActivity(), DoctorProfile.class);
            intent.putExtra("DOCTOR_NAME", doctorName);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        // Set the layout manager (e.g., LinearLayoutManager)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

    // Create a method to generate a list of specialists (replace this with your data source)
    private List<doctorList> createSpecialistList() {
        List<doctorList> specialistList = new ArrayList<>();
        // Add Specialist objects to the list
        // Replace the following lines with your actual data
        specialistList.add(new doctorList("Dr. Jamila", R.drawable.jamila,"pediatrician","7 Years",4.5f));
        specialistList.add(new doctorList("Dr. Jamil", R.drawable.jamil,"Cardiologist","5 Years",4f));
        specialistList.add(new doctorList("Dr. Mansour", R.drawable.mansour,"Neurologist","4 Years",4f));
        specialistList.add(new doctorList("Dr. Malek", R.drawable.tbiba,"Hepatologist","3 Years",4f));
        specialistList.add(new doctorList("Dr. Moueez", R.drawable.moueez,"nephrologist","3 Years",3.5f));
        specialistList.add(new doctorList("Dr. Asma", R.drawable.asma,"Pulmonologist","4 Years",4.5f));
        specialistList.add(new doctorList("Dr. Majdi", R.drawable.majid,"gastroenterologist","3 Years",3.5f));

        // Add other specialists as needed
        return specialistList;
    }
}
