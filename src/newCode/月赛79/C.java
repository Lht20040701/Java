package newCode.月赛79;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        Arrays.fill(arr, 0);

        int ans = 0;
        Set<Integer> st = new HashSet<>();
        boolean f = false;

        for (int i = 1; i <= n; i ++ ) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i ++ ) {
            if (arr[i] == 0) {
                ans = Math.max(ans, arr[i - 1]);
                ans = Math.max(ans, arr[i + 1]);
//                System.out.println("Now : ans = " + ans);
            }
            st.add(arr[i]);
            if (arr[i] != 0) f = true;
        }

        int bigMex = 0;
        for (int i = 0; i <= 100010; i ++ ) {
            if (!st.contains(i)) {
                bigMex = i;
                break;
            }
        }

//        System.out.println(ans + " " + bigMex);
        ans = Math.max(ans, bigMex);
        if (f) System.out.println(ans);
        else System.out.println(0);
    }
}
