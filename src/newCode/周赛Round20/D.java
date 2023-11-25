package newCode.周赛Round20;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.next(), y = sc.next();
        int wx = x.length(), wy = y.length();

        /**
         * 思路 : 二进制暴力枚举, 如果是0就代表删除该位置上的数字
         *      比如 -> x = 1234567890 注意x的左边是高位, 左右是低位
         *             i = 1010101010 注意i的左边是低位, 右边是高位 (到过来算的原因主要是因为我们选newx的公式的时候是newx = new * 10 + 不删除的位置 -> 导致我们需要先从高位看删不删
         *
         *             所以最后得到的newx = 24680
         * */


        int ans = 0x3f3f3f3f;
        for (int i = 0; i < (1 << wx); i ++ ) {
            int newx = 0, dx = 0;
            for (int j = 0; j < wx; j ++ )
                if (((i >> j) & 1) == 1) {
                    newx = newx * 10 + x.charAt(j) - '0';
                    dx ++ ;
                }
            dx = wx - dx;


            for (int k = 0; k < (1 << wy); k ++ ) {
                int newy = 0, dy = 0;
                for (int j = 0; j < wy; j ++ )
                    if (((k >> j) & 1) == 1) {
                        newy = newy * 10 + y.charAt(j) - '0';
                        dy ++ ;
                    }
                dy = wy - dy;

                if (newx == 0 || newy == 0) continue;

                if (newx % newy == 0 || newy % newx == 0) ans = Math.min(ans, dx + dy);
            }
        }

        if (ans != 0x3f3f3f3f) System.out.println(ans);
        else System.out.println(-1);
    }
}
