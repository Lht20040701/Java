package 算法保持;

import java.math.BigInteger;
import java.util.Scanner;

public class acw3551 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 1; i <= t; i ++ ) {
            BigInteger bi = new BigInteger(sc.next());

            StringBuilder sb = new StringBuilder(bi.toString(2));

            for (int j = sb.toString().length(); j <= 31; j ++ ) {
                sb.insert(0, "0");
            }

            bi = new BigInteger(sb.reverse().toString(), 2);
            System.out.println(bi);
        }
    }
}
