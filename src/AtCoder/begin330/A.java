package AtCoder.begin330;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), l = sc.nextInt();

        int ans = 0;
        for (int i = 1; i <= n; i ++ ) {
            int x = sc.nextInt();
            if (x >= l) ans ++ ;
        }

        System.out.println(ans);
    }
}