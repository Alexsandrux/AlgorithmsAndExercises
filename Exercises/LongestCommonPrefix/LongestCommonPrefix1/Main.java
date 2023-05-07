import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String longestPrefix = strs[0];

        for (int i = 1; i < strs.length ; i++) {
            while (true)
            {
                if(longestPrefix.length() <= strs[i].length() && longestPrefix.equals(strs[i].substring(0, longestPrefix.length()))) {
                    break;
                }
                else {
                    longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
                }

                if(longestPrefix.equals("")) break;
            }
        }

        return longestPrefix;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println(new Solution().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));

    }
}