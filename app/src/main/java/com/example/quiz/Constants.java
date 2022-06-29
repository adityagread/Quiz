package com.example.quiz;

import java.util.ArrayList;

public class Constants {

    public Constants() {
    }

    public ArrayList<Questions> getQuestions(){
        ArrayList<Questions> questionsArrayList = new ArrayList<>();
        Questions que1 = new Questions(
                1, "What country does this flag belong to?",
                R.drawable.ic_flag_of_argentina,
                "Argentina", "Australia",
                "Armenia", "Austria", 1
        );
        questionsArrayList.add(que1);

        // 2
        Questions que2 = new Questions(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Angola", "Austria",
                "Australia", "Armenia", 3
        );
        questionsArrayList.add(que2);

        // 3
        Questions que3 = new Questions(
                3, "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Belarus", "Belize",
                "Brunei", "Brazil", 4
        );
        questionsArrayList.add(que3);

        // 4
        Questions que4 = new Questions(
                4, "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Bahamas", "Belgium",
                "Barbados", "Belize", 2
        );
        questionsArrayList.add(que4);

        // 5
        Questions que5 = new Questions(
                5, "What country does this flag belong to?",
                R.drawable.ic_flag_of_fiji,
                "Gabon", "France",
                "Fiji", "Finland", 3
        );
        questionsArrayList.add(que5);

        // 6
        Questions que6 = new Questions(
                6, "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Germany", "Georgia",
                "Greece", "none of these", 1
        );
        questionsArrayList.add(que6);

        // 7
        Questions que7 = new Questions(
                7, "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Dominica", "Egypt",
                "Denmark", "Ethiopia", 3
        );
        questionsArrayList.add(que7);

        // 8
        Questions que8 = new Questions(
                8, "What country does this flag belong to?",
                R.drawable.ic_flag_of_india,
                "Ireland", "Iran",
                "Hungary", "India", 4
        );
        questionsArrayList.add(que8);

        // 9
        Questions que9 = new Questions(
                9, "What country does this flag belong to?",
                R.drawable.ic_flag_of_new_zealand,
                "Australia", "New Zealand",
                "Tuvalu", "United States of America", 2
        );
        questionsArrayList.add(que9);

        // 10
        Questions que10 = new Questions(
                10, "What country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Kuwait", "Jordan",
                "Sudan", "Palestine", 1
        );
        questionsArrayList.add(que10);

        return questionsArrayList;
    }
}
