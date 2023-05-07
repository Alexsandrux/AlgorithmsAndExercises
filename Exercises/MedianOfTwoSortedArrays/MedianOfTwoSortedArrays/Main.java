import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = -1;

        List<Integer> sortedMergedList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length)
        {
            if(nums1[i] <= nums2[j])
            {
                sortedMergedList.add(nums1[i]);
                i++;
            }
            else {
                sortedMergedList.add(nums2[j]);
                j++;
            }
        }

        if(i == nums1.length) {
            for (int k = j; k < nums2.length; k++) {
                sortedMergedList.add(nums2[k]);
            }
        }
        else {
            for (int k = i; k < nums1.length; k++) {
                sortedMergedList.add(nums2[k]);
            }
        }

        System.out.println(sortedMergedList);

        if(sortedMergedList.size() % 2 == 1)
        {
            median = sortedMergedList.get(sortedMergedList.size() / 2);
        }
        else {
            median = ((double) sortedMergedList.get(sortedMergedList.size() / 2) +
                    (double) sortedMergedList.get(sortedMergedList.size() / 2 -1)) / 2;
        }

        return median;
    }
}

// I'll have to redo this is one because the time complexity of it is (O(m+n)) not (O(log(m+n))) as it is requested
public class Main {
    public static void main(String[] args) {

        System.out.println((new Solution().findMedianSortedArrays(new int[] {1, 2 }, new int[] {3, 4})));

    }
}