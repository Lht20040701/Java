package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> lis = new ArrayList<>();

        for (int x : nums1) lis.add(x);
        for (int x : nums2) lis.add(x);

        lis.sort((a, b) -> a - b);
        double ans = 0;
        if (lis.size() % 2 == 1) ans = lis.get(lis.size() / 2);
        else {
            int sum = lis.get(lis.size() / 2) + lis.get(lis.size() / 2 - 1);
            ans = 1.0 * sum / 2;
        }
        return ans;
    }
}
