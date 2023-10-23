package seminars.third.tdd;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDrivenDevelopment {

        MoodAnalyser moodAnalyser;
        @BeforeEach
        void  setUp(){
            moodAnalyser = new MoodAnalyser();
        }

        //3.5. Red-Green-Refactor
        @ParameterizedTest
        @ValueSource(strings = {"Hi","Hello", "Ok"})
        void checkGoodMood(String input){
            String actual = moodAnalyser.analyseMood(input);

            assertThat(actual).isEqualTo("Great");
        }

        @ParameterizedTest
        @ValueSource(strings = {"By", "Sad", "Bad"})
        void checkBadMood(String input){
            String actual = moodAnalyser.analyseMood(input);

            assertThat(actual).isEqualTo("You make me sadly");
        }

        @ParameterizedTest
        @ValueSource(strings = {"..", "...", "...."})
        void checkUnknownMood(String input){
            String actual = moodAnalyser.analyseMood(input);

            assertThat(actual).isEqualTo("What are you mean?");
        }
}
