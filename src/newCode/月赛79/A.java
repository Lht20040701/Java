package newCode.月赛79;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (true) {
            int w = (int) Math.log10(n) + 1;
            if (n % 10 % 2 == 1) {
                if (w == 1) {
                    cnt ++ ;
                    break;
                }
                n /= 10;
            } else {
                break;
            }
            cnt ++ ;
        }
        System.out.println(cnt);
    }
}
