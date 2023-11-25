package 算法保持;

import java.math.BigInteger;
import java.util.Scanner;

public class acw3554 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t -- > 0) solved();
    }

    private static void solved() {
        String s = sc.next();
        BigInteger bi = new BigInteger(s, 2);
        BigInteger t = new BigInteger(s, 2);

        StringBuilder sb1 = new StringBuilder(bi.add(BigInteger.valueOf(1)).toString(2));

        for (int i = sb1.toString().length() + 1; i <= 32; i ++ ) {
            sb1.insert(0, "0");
        }
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder(t.add(BigInteger.valueOf(3)).toString(2));
        for (int i = sb2.toString().length() + 1; i <= 32; i ++ ) {
            sb2.insert(0, "0");
        }
        System.out.println(sb2);
    }
}

//输出
//        00000000000000000000000000000001
//        000000000000000000000000000000011
//        00000000000000000000000000000010
//        000000000000000000000000000000100

//输出样例：
//        00000000000000000000000000000001
//        00000000000000000000000000000011
//        00000000000000000000000000000010
//        00000000000000000000000000000100