package 算法保持;

import java.util.Arrays;
import java.util.Scanner;

public class acw5056 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i ++ ) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int la = arr[0];

        for (int i = 0; i < n; i ++ ) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        System.out.print(la + " ");
        for (int i = 1; i < n; i ++ ) {
            if (arr[i] == la) continue;
            System.out.print(arr[i] + " ");
            la = arr[i];
        }
    }
}
