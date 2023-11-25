package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw1012 {
    /**
     * 转化思路 : 保证一边枚举有序的前提下只需要另一边找出来的边同样有序就好了
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n + 10][2];

        for (int i = 0; i < n; i ++ ) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, 0, n, (o1, o2) -> o1[0] - o2[0]);
//        System.out.println(Arrays.deepToString(a));

        int[] p = new int[n + 10];
        p[0] = -1;
        int len = 0;
        for (int i = 0; i < n; i ++ ) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (p[mid] < a[i][1]) l = mid;
                else r = mid - 1;
            }

            len = Math.max(len, r + 1);
            p[r + 1] = a[i][1];
        }

        System.out.println(len);
    }
}
