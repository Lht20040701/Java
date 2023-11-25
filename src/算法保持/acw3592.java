package 算法保持;

import java.util.Scanner;

public class acw3592 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[][] arr = new int[n + 10][n + 10];

        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < n; j ++ ) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < n; j ++ ) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println("");
        }
    }
}
