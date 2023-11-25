package 算法保持;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class acw3542 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<Integer> st = new HashSet<>();

        int n = sc.nextInt();

        for (int i = 1; i <= n; i ++ ) {
            int x = sc.nextInt();
            st.add(x);
        }

        int m = sc.nextInt();
        for (int i = 1; i <= m; i ++ ) {
            int x = sc.nextInt();
            if (st.contains(x)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
