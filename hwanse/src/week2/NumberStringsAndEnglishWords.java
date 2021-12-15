package week2;

import java.util.regex.Pattern;

public class NumberStringsAndEnglishWords {

    public int solution(String s) {
        String tempString = s;

        while (!isNumbers(tempString)) {
            for (Number type : Number.values()) {
                String numberString = type.name().toLowerCase();

                if (tempString.contains(numberString)) {
                    tempString = tempString.replaceAll(numberString, String.valueOf(type.getValue()));
                    break;
                }
            }
        }

        return Integer.parseInt(tempString);
    }

    public boolean isNumbers(String numberString) {
        return Pattern.matches("^[0-9]+$", numberString);
    }

}

enum Number {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}