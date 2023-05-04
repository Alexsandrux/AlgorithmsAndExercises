import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> romanLetters = new HashMap<>();
        romanLetters.put("I", 1);
        romanLetters.put("V", 5);
        romanLetters.put("X", 10);
        romanLetters.put("L", 50);
        romanLetters.put("C", 100);
        romanLetters.put("D", 500);
        romanLetters.put("M", 1000);

        int number = 0;

        String s = "LVIII";

        for (int i = s.length() - 1; i >= 0 ; i--) {

            String letter = String.valueOf(s.charAt(i));


            int letterValue = romanLetters.get(letter);

            number += (4 * letterValue < number) ? -letterValue : letterValue;


        }

        System.out.println(number);

    }
}