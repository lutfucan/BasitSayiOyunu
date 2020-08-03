package sample;

import java.util.List;

public class GuessIt {

    Utils util = new Utils();
    Randomizer randomizer = new Randomizer();
    String message = "";
    boolean found = false;


    public boolean guessTheNumber(int number, int guess) {
        List<Integer> digitsNumber = util.divideDigits(number);
        List<Integer> digitsGuess = util.divideDigits(guess);
        if (!randomizer.areDigitsDifferent(guess)) {
            message = "Rakamları farklı sayı girmelisiniz";
        } else {
            if (digitsNumber.size() != digitsGuess.size()) {
                message = digitsNumber.size() + " rakamlı sayı girmelisiniz";
            } else {
                if (!digitsNumber.equals(digitsGuess)) {
                    message = "D : " + rightInPlace(digitsNumber, digitsGuess) +  " -- Y : "
                            + (totalFound(digitsNumber, digitsGuess) - rightInPlace(digitsNumber, digitsGuess));
                } else {
                    message = "Tebrikler";
                    found = true;
                }
            }
        }
        return found;
    }

    public int rightInPlace(List<Integer> numberDigits, List<Integer> guessDigits) {
        int rightInPlace = 0;
        for (int i = 0; i < guessDigits.size(); i++) {
            if (guessDigits.get(i).equals(numberDigits.get(i))) {
                rightInPlace++;
            }
        }
        return rightInPlace;
    }

    public int totalFound(List<Integer> numberDigits, List<Integer> guessDigits) {
        int totalFound = 0;
        for (int i = 0; i < guessDigits.size(); i++) {
            if (numberDigits.contains(guessDigits.get(i))) {
                totalFound++;
            }
        }
        return totalFound;
    }
}
