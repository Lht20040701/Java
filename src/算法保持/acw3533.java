package 算法保持;

import java.util.Arrays;
import java.util.Scanner;

public class acw3533 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i ++ ) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(arr);

        int now = 0; int la = -1;
        int i;
        for (i = 0; i < n; i ++ ) {
            if (arr[i] != la) {
                la = arr[i];
                now ++ ;
            }

            if (now == k) break;
        }

        System.out.println(arr[i]);
    }
}
