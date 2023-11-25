package leetcode;

import java.util.PriorityQueue;

public class lec2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < gifts.length; i ++ ) pq.add(gifts[i]);

        for (int i = 1; i <= k; i ++ ) {
            int x = pq.poll();
            x = (int) Math.floor(Math.sqrt(x));
            pq.add(x);
        }

        long ans = 0;
        for (int x : pq) ans += x;
        return ans;
    }
}
