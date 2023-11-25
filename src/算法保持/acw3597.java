package 算法保持;

import java.util.Arrays;
import java.util.Scanner;

public class acw3597 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i ++ ) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[n - 1]);
        if (n == 1) System.out.println(-1);
        else {
            for (int i = 0; i < n - 1; i ++ ) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
