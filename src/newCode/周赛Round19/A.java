package newCode.周赛Round19;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);


        for (int i = 0; i < k; i++) {
            if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') sb.setCharAt(i, (char) (sb.charAt(i) - 32));
        }

        for (int i = k; i < sb.length(); i++) {
            if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') sb.setCharAt(i, (char) (sb.charAt(i) + 32));
        }
        System.out.println(sb);
    }
}
