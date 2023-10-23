package homeworks.third.HW;

import homeworks.third.HW.NumberChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberCheckerTest {
    NumberChecker numberChecker;

    @BeforeEach
    void setUp() {
        numberChecker = new NumberChecker();
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6})
    void numberIsOdd (int num){
        assertTrue(numberChecker.isOdd(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5})
    void numberIsNotOdd (int num){
        assertFalse(numberChecker.isOdd(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {30,50,90})
    void numberInInterval (int num){
        assertTrue(numberChecker.inInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {10,20,150})
    void numberOutOfInterval (int num){
        assertFalse(numberChecker.inInterval(num));
    }
}
