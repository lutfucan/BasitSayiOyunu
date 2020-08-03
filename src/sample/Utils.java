package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    //Sayıyı rakamlara böler
    public List<Integer> divideDigits(int number) {
        int temp = number;
        //int count = 0;
        int digit = 0;
        List<Integer> resultList = new ArrayList<>();

        while (number > 0) {
            number = number / 10;
            //count++;
        }
        while (temp > 0) {
            digit = temp % 10;
            resultList.add(digit);
            temp = temp / 10;
            //count--;
        }
        Collections.reverse(resultList);
        return resultList;
    }

}
