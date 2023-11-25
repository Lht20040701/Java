package 蓝桥杯;

import java.util.Arrays;
import java.util.Scanner;

public class lanqiao3994 {

    /**
     * 思路 :
     *      固定套路了感觉, 先按直径从大到小排, 然后直径相同的再按高度从小到大排
     *      然后从前往后遍历的时候就可以在一定存在更大d的前提下, 判断我前面是否有更大的h (在我前面最大的h用maxH记录) 即可 (其中d相同h必须按照从小到大, 因为前面d相同的h比我大了没用, 所以应该最后再更新maxH)
     *      整体下来时间复杂度是 O(n log n)
     *      想不出来这个就打暴力 O(n * n)
     *
     * */
    private static class PII implements Comparable {
        int d, h;
        public PII(int d, int h) {
            this.d = d;
            this.h = h;
        }

        @Override
        public int compareTo(Object o) {
            PII t = (PII) o;
            if (t.d != this.d) return t.d - this.d;
            return this.h - t.h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PII[] pi = new PII[n + 10];

        for (int i = 1; i <= n; i ++ ) {
            int x = sc.nextInt(), y = sc.nextInt();
            pi[i] = new PII(x, y);
        }

        Arrays.sort(pi, 1, 1 + n);


        int ans = 0;
        int maxH = 0;
        for (int i = 1; i <= n; i ++ ) {
            if (maxH <= pi[i].h) {
                maxH = pi[i].h;
                ans ++ ;
            }
        }

        System.out.println(ans);
    }
}