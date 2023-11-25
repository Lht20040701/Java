package 蓝桥杯;

import java.util.Scanner;

public class lanqiao504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i ++ ) {
            alphabet[s.charAt(i) - 'a'] ++ ;
        }

        char x = 'a';
        for (int i = 0; i < 26; i ++ ) {
            if (alphabet[i] > alphabet[x - 'a']) x =  (char)(i + 'a');
        }

        System.out.println(x);
        System.out.println(alphabet[x - 'a']);
    }
}
