package leetcode;

import java.util.Stack;

public class lec739 {
    class PII {
        int x, y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "PII{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        PII[] pi = new PII[n];
        Stack<PII> sta = new Stack<>();
        for (int i = 0; i < n; i ++ ) pi[i] = new PII(temperatures[i], i);

        int[] ans = new int[n];
        for (int i = 0; i < n; i ++ ) {
            while (!sta.isEmpty()) {
                PII e = sta.peek();
//                System.out.println(e);
                if (e.x < pi[i].x) {
                    sta.pop();
                    ans[e.y] = pi[i].y - e.y;
                } else break;
            }
            sta.push(pi[i]);
        }

        while (!sta.isEmpty()) {
            PII e = sta.pop();
            ans[e.y] = 0;
        }

        return ans;
    }
}
