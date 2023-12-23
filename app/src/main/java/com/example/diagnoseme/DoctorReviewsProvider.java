package com.example.diagnoseme;

import java.util.ArrayList;
import java.util.List;

public class DoctorReviewsProvider {

    public static List<PersonalInfromation> getReviewsForDoctor(String doctorName) {
        List<PersonalInfromation> reviews = new ArrayList<>();

        switch (doctorName) {
            case "Dr. Jamila":
                reviews.add(new PersonalInfromation("Nefaa battikh",R.drawable.nefaa,4.0f,"the best lungs doctor ever thank you Dr. Asma"));
                reviews.add(new PersonalInfromation("Mourad blinta",R.drawable.mourad,4.5f,"superb!"));
                break;

            case "Dr. Jamil":
                reviews.add(new PersonalInfromation("Salma", R.drawable.salma, 5f, "Empathetic and skilled. She made my surgery experience less daunting."));
                reviews.add(new PersonalInfromation("Haythem", R.drawable.haythem, 3.5f, "I appreciate Dr. Jamil's holistic approach to treatment. Very knowledgeable and caring"));
                break;
            case "Dr. Malek":
                reviews.add(new PersonalInfromation("Abd Rahmen", R.drawable.abd_rahmen, 3f, "The best Hepatologist bravo!!"));
                reviews.add(new PersonalInfromation("Chayma Sultan", R.drawable.chayma, 4.5f, "I appreciate Dr. Malek's holistic approach to treatment. Very knowledgeable and caring"));
                break;
            case "Dr. Moueez":
                reviews.add(new PersonalInfromation("Marwen", R.drawable.marwen, 3.5f, "Quick and accurate diagnosis by Dr. Moueez. his treatment plan worked wonders for me."));
                reviews.add(new PersonalInfromation("Ilef", R.drawable.ilef, 4f, "Dr. Moueez's treatment was effective and his advice was invaluable. Feeling much better now."));
                break;
            case "Dr. Asma":
                reviews.add(new PersonalInfromation("Soulayma", R.drawable.soulayma, 4f, "Dr. Salma has a great bedside manner and a reassuring presence. A true professional."));
                reviews.add(new PersonalInfromation("Radhwen", R.drawable.radhwen, 3.5f, "Grateful for Dr. Salma's expertise. She diagnosed a problem that others missed."));
                break;
            case "Dr. Majdi":
                reviews.add(new PersonalInfromation("Ahlem", R.drawable.ahlem, 4.5f, "Very patient and answered all my queries. Exceptional service!"));
                reviews.add(new PersonalInfromation("Youssef", R.drawable.youssef, 3f, "Impressed with Dr. Majdi's knowledge and care. My health has improved greatly under her guidance."));
                break;
            // ... cases for other doctors
            case "Dr. Mansour":
                reviews.add(new PersonalInfromation("Mouhaned", R.drawable.mouhanid, 4.5f, "Dr. Mansour is incredibly attentive and thorough. Best experience I've ever had with a doctor!"));
                reviews.add(new PersonalInfromation("Fakhriya", R.drawable.fakhriya, 4f, "Friendly approach made my consultation very comfortable. Highly recommend!"));
                break;
            default:
                // Optionally handle the case where no doctor name matches
                break;
        }

        return reviews;
    }
}
