package 实验报告.点餐;

import java.util.Scanner;

public class OrderFood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        order(sc.next());
        order(sc.next(), sc.nextInt());
        order(sc.next(), sc.nextInt(), sc.next());
    }

    public static void order(String name, int num, String request) {
        System.out.println(name + " " + num + "份 " + request);
    }

    public static void order(String name) {
        System.out.println(name);
    }

    public static void order(String name, int num) {
        System.out.println(name + " " + num + "份");
    }
}
