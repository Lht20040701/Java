package leetcode;

import java.util.*;

public class lec239N {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> lis = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i ++ ) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) deque.removeLast();
            deque.addLast(i);
            if (i >= k - 1) {
                while (!deque.isEmpty() && deque.getFirst() <= i - k) deque.removeFirst();
                lis.add(nums[deque.getFirst()]);
            }
        }

        int[] ans = new int[lis.size()];
        for (int i = 0; i < ans.length; i ++ ) ans[i] = lis.get(i);
        return ans;
    }
}
