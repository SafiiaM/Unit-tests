package seminars.third.coverage;

public class SomeService {
    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5,
     * и FizzBuzz для кратных 3 и 5 одновременно
     */
    public String fizzBuzz(int input) {
        if(input % 3 == 0 && input % 5 == 0)
            return "FizzBuzz";
        if (input % 3 == 0) {
            return "Fizz";
        }else if (input % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(input);
    }

    /**
     * 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6,
     * и false - если 6 нет ни в начале ни в конце массива
     */
    public boolean firstLast6(int[] array) {
        if(array == null || array.length == 0) return false;

        if(array[0] == 6 || array[array.length - 1] == 6) return true;
        return false;
    }


    /**
     * 3.3. Метод подсчета скидки
     */
    public double calculatingDiscount(double purchase, int discount) {
        if(purchase < 0)
            throw new IllegalArgumentException
                    ("purchase can't be less than zero");
        if(discount < 0)
            throw new IllegalArgumentException
                    ("discount can't be less than zero");
        if(discount > 100)
            throw new IllegalArgumentException
                    ("discount can't be greater than zero");

        return purchase - purchase * discount / 100;
    }
    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму.
     * Однако, если одно из значений равно 13,
     * то оно не учитывается в сумме. Так, например, если b равно 13, то считается сумма только a и c.
     */

    public int calculatingSumThreeNumbers(int first, int second, int third) {
        int result = 0;
        if(first!= 13) result += first;
        if(second!= 13) result += second;
        if(third!= 13) result += third;
        return result;
    }



}
