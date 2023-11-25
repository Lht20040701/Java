package 算法保持;

import java.math.BigInteger;
import java.util.Scanner;

public class acw3596 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (sc.hasNext()) {
            BigInteger b1 = new BigInteger(sc.next());
            BigInteger b2 = new BigInteger(sc.next());
            System.out.println(b1.add(b2));
        }
    }
}
