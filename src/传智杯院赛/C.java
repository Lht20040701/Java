package 传智杯院赛;

import java.util.Scanner;

public class C {
    static long n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        m = sc.nextLong();

        if (n * m % 2 == 1) System.out.println("akai");
        else System.out.println("yukari");
    }
}
