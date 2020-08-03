package sample;

import java.util.ArrayList;
import java.util.List;

public class Randomizer {

    public int produce(int len) {

        int max = 0;
        int min = 0;

        max = (int) Math.pow(10, len);
        min = (int) Math.pow(10, len -1);

        int myNumber = 0;
        do {
            myNumber = (int) ((Math.random() * (max - min)) + min);
        }while((!areDigitsDifferent(myNumber)));
        return myNumber;
    }

    public int digitCount(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            ++count;
        }
        return count;
    }

    //Rakamlar birbirinden farklı mı kontrol eder.
    public boolean areDigitsDifferent(int number) {
        List<Integer> digits = new Utils().divideDigits(number);

        List<Integer> newList = new ArrayList<>();

        for (Integer digit : digits) {
            if (!newList.contains(digit)) {
                newList.add(digit);
            }
        }
        if(digits.size() == newList.size()) {
            return true;
        }
        return false;
    }


}
