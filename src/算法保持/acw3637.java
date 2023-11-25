package 算法保持;

import java.math.BigInteger;
import java.util.Scanner;

public class acw3637 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger bi = new BigInteger(sc.next());

        String t = bi.toString(2);

        int c1 = 0;

        for (int i = 0; i < t.length(); i ++ ) {
            if (t.charAt(i) == '1') c1 ++ ;
        }
        System.out.println(32 - c1 + " " + c1);
    }
}
