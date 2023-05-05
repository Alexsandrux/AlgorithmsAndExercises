import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int j = 1;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length)
            {
                if(nums[i] + nums[j] == target) return new int[] {i, j};
                j++;
            }
            j = i+2;
        }

        return new int[] {-1, -1};
    }
}
public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3,2,4},  7)));

    }
}