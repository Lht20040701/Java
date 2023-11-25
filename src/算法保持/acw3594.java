package 算法保持;

import java.util.Scanner;

public class acw3594 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (sc.hasNext()) solved();
    }

    private static void solved() {
        String s = sc.next();

        if (s.matches("(([0-9]|[1-9]\\d{1}|1\\d{2}|2[0-4]\\d|25[0-5])\\.?){4}")) System.out.println("Yes!");
        else System.out.println("No!");
    }
}
