package newCode.月赛79;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;
        int odd = 0;
        int minOdd = 0x3f3f3f3f;
        for (int i = 0; i < n; i ++ ) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 1) {
                odd ++ ;
                minOdd = Math.min(minOdd, arr[i]);
            }
            ans += arr[i];
        }
        if (odd % 2 == 0) {
            System.out.println(ans);
        } else {
            ans -= minOdd;
            System.out.println(ans);
        }
    }
}
