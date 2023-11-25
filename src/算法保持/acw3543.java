package 算法保持;

import java.util.Scanner;

public class acw3543 {
    static Scanner sc = new Scanner(System.in);

    static void solved() {
        int m = sc.nextInt();

        int[] arr = new int[m];

        for (int i = 0; i < m; i ++ ) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < m; i ++ ) {
            for (int j = 0; j < m; j ++) {
                for (int k = 0; k < m; k ++ ) {
                    int t = arr[i] + arr[j];
                    if (t == arr[k]) ans ++ ;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {

        int n = sc.nextInt();
        for (int i = 1; i <= n; i ++ ) solved();
    }
}
