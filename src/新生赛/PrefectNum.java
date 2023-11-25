package 新生赛;

import java.math.BigInteger;
import java.util.Scanner;

public class PrefectNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger bi = new BigInteger(sc.nextLine());

        BigInteger[] a = bi.divideAndRemainder(BigInteger.valueOf(3));
        if (a[1].equals(BigInteger.valueOf(0))) System.out.println("true");
        else System.out.println("false");
    }
}
