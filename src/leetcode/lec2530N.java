package leetcode;

import java.util.PriorityQueue;

public class lec2530N {
    public int ceil(int a, int b) {
        return (a + b - 1) / b;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        for (int x : nums) pq.add(x);
        while (k --  > 0) {
            int x = pq.poll();
            ans += x;
            pq.add(ceil(x, 3));
        }
        return ans;
    }
}
