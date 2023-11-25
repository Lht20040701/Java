package 算法保持;

import java.util.Scanner;

public class acw3593 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (sc.hasNext()) {
            String l = sc.next();
            if (l.charAt(l.length() - 1) == '.') {
                System.out.print(l.length() - 1);
            } else {
                System.out.print(l.length());
            }
            System.out.print(" ");
        }
    }
}
