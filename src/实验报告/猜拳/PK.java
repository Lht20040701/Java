package 实验报告.猜拳;

import java.util.Random;
import java.util.Scanner;

public class PK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1, p2;
        p1 = p2 = 0;

//        1剪刀 2石头 3布
        for (int i = 1; i <= 5; i ++ ) {
            Random ra = new Random();
            int ro = ra.nextInt(3) + 1;
            System.out.println("第" + i + "局" + ", 请输入 : 1剪刀 2石头 3布");
            int me = sc.nextInt();

            System.out.println("你是" + convert(me));
            System.out.println("他是" + convert(ro));
            if (ro == me) {
                System.out.println("平局");
                continue;
            }

            int gap = Math.abs(ro - me);

            if (gap == 2) {
                if (ro == 3) p1 ++ ;
                else if (me == 3) p2 ++ ;
                continue;
            }

            if (gap == 1 && ro < me) {
                p1 ++ ;
            } else if (gap == 1 && ro > me) {
                p2++;
            }
        }

        if (p1 == p2) System.out.println("你们两个平手了");
        else if (p1 > p2) System.out.println("你赢了");
        else System.out.println("你输了");
    }

    public static String convert (int i) {
        if (i == 1) return "剪刀";
        else if (i == 2) return "石头";
        else return "布";
    }
}