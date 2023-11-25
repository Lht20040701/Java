package 算法保持;

import java.math.BigInteger;
import java.util.Scanner;

public class acw3530 {
    static Scanner sc = new Scanner(System.in);

    static void solved() {
        BigInteger bi = new BigInteger(sc.next());
        System.out.println(bi.toString(2));
    }

    public static void main(String[] args) {
        while (sc.hasNext()) solved();
    }
}
