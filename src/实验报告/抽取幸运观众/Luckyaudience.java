package 实验报告.抽取幸运观众;

import java.util.Random;
import java.util.Scanner;

public class Luckyaudience {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("几位观众");
        int n = sc.nextInt();
        audience[] au = new audience[n];

        for (int i = 0; i < n; i ++ ) {
            au[i] = new audience();
        }

//        System.out.println(au.length);
        System.out.println("输入名字");
        for (int i = 0; i < au.length; i ++ ) {
            au[i].setName(sc.next());
        }

        show(au);
        extract(au);
    }

    public static void show(audience[] au) {
        for (int i = 0; i < au.length; i ++ ) {
            System.out.println(au[i].getName());
        }
    }

    public static void extract(audience[] au) {
        Random ra = new Random();
        int i = ra.nextInt(au.length);
        System.out.println("幸运观众是 : " + au[i].getName());
    }
}
/**
 *
 * 几位观众
 * 3
 * 输入名字
 * 李菜菜
 * 狗蛋
 * 卤蛋
 * 李菜菜
 * 狗蛋
 * 卤蛋
 * 幸运观众是 : 卤蛋
 *
 *
 */
