package 大整数;

import java.math.BigInteger;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger bi = new BigInteger(sc.nextLine());
        System.out.println(bi.add(new BigInteger(sc.nextLine())));
    }
}
