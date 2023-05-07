import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String xString = String.valueOf(x);

        int xLength =  xString.length();

        for (int i = 0; i < xLength / 2; i++) {
            if(xString.charAt(i) != xString.charAt(xLength - 1 - i)) return false;
        }


        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println((new Solution().isPalindrome(10)));

    }
}