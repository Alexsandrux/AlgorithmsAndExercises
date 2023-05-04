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
        for (int i = 0; i < s.length(); i++) {

            String letter = String.valueOf(s.charAt(i));



            if((s.length() - 1) == i)
            {
                number += romanLetters.get(letter);
                break;
            }

            if(letter.equals("I"))
            {
                String nextLetter = String.valueOf(s.charAt(i+1));
                if (nextLetter.equals("V"))
                {
                    number += (romanLetters.get(nextLetter) - romanLetters.get(letter));
                    i++;
                    continue;
                }
                if (nextLetter.equals("X")) {
                    number += (romanLetters.get(nextLetter) - romanLetters.get(letter));
                    i++;
                    continue;
                }
            }

            if(letter.equals("X"))
            {
                String nextLetter = String.valueOf(s.charAt(i+1));
                if (nextLetter.equals("L"))
                {
                    number += (romanLetters.get(nextLetter) - romanLetters.get(letter));
                    i++;
                    continue;
                }
                if (nextLetter.equals("C")) {
                    number += (romanLetters.get(nextLetter) - romanLetters.get(letter));
                    i++;
                    continue;
                }
            }

            if(letter.equals("C"))
            {
                String nextLetter = String.valueOf(s.charAt(i+1));
                if (nextLetter.equals("D"))
                {
                    number += (romanLetters.get(nextLetter) - romanLetters.get(letter));
                    i++;
                    continue;
                }
                if (nextLetter.equals("M")) {
                    number += (romanLetters.get(nextLetter) - romanLetters.get(letter));
                    i++;
                    continue;
                }
            }

            number += romanLetters.get(letter);

        }

        System.out.println(number);
    }
}