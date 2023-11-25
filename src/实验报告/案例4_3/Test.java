package 实验报告.案例4_3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("你想选择哪一个 ? \n" +
                "1 收音机\n" +
                "2 移动手机\n" +
                "3 随身听");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x) {
            case 1 : hear(new Radio()); break;
            case 2 : hear(new MobliePhone()); break;
            case 3 : hear(new Walkman()); break;
        }
    }

    public static void hear(SoundAble s) {
        s.sound();
    }
}
