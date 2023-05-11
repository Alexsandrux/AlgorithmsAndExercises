import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution {
    HashMap<String, Integer> numbers = new HashMap<>();

    Solution() {
        numbers.put("1", 1);
        numbers.put("2", 2);
        numbers.put("3", 3);
        numbers.put("4", 4);
        numbers.put("5", 5);
        numbers.put("6", 6);
        numbers.put("7", 7);
        numbers.put("8", 8);
        numbers.put("9", 9);
    }

    public int myAtoi(String s) {
        s = s.trim();

        int number = 0;

        boolean isFirstLetterTheSign = String.valueOf(s.charAt(0)).equals("-");

        if (!isFirstLetterTheSign && numbers.containsKey(String.valueOf(s.charAt(0))))
            number = numbers.get(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            String currentLetter = String.valueOf(s.charAt(i));

            if (!numbers.containsKey(currentLetter)) break;

            number = (number == 0) ?
                    number + numbers.get(currentLetter) :
                    number * 10 + numbers.get(currentLetter);

        }

        if (isFirstLetterTheSign) number *= -1;

        return number;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println(new Solution().myAtoi("    -42"));


    }
}