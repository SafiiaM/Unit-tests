package seminars.third.tdd;

import java.util.Arrays;

public class MoodAnalyser {
    String[] good = new String[]{"Hi","Hello", "Ok"};
    String[] bad = new String[]{"By", "Sad", "Bad"};

    public String analyseMood(String message) {

        if(Arrays.asList(good).contains(message)) {
            return "Great";
        }
        if(Arrays.asList(bad).contains(message)) {
            return "You make me sadly";
        }
        return "What are you mean?";
    }

}
