package homeworks.first.HW;

import static org.assertj.core.api.Assertions.*;
import static seminars.first.Calculator.Calculator.calculatingDiscount;

public class task_1 {
    public static void main(String[] args) {
        assertThatThrownBy(() -> calculatingDiscount(1000.0, -10))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> calculatingDiscount(0.0, 15))
                .isInstanceOf(ArithmeticException.class);
        calculatingDiscount(1000.0, -10);
        calculatingDiscount(0.0, 15);
    }
}
