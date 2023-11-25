package 算法提高课;

import java.util.Scanner;

public class acw1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 10];
            int[] f = new int[n + 10];

            for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
            f[0] = 0;
            f[1] = a[1];

            for (int i = 2; i <= n; i ++ ) f[i] = Math.max(f[i - 1], f[i - 2] + a[i]);
            System.out.println(f[n]);
        }
    }
}

// 状态机注重过程, 而普通dp注重结果
// 普通dp依赖前两层, 状态机依赖上一层
class acw1049Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 10];
            for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
            int[][] f = new int[n + 10][2]; // 每走一步就是对一家店铺的选择, 而我们走了i步以后有两种状态, 走到了0, 走到了1

            /**
             * 本题状态机 : (0)代表走了i步走到了不选的位置, (1)代表走了i步走到了选的位置
             *
             *                 不选
             *                |---|
             *                |   |
             *                \/  /   选
             *        |------>(0)-----------> (1)
             *        |                        |
             *        |------------------------|
             *                  不选
             * */

            // 初始状态机
            f[0][0] = 0;
            f[0][1] = -0x3f3f3f3f;
            //

            for (int i = 1; i <= n; i ++ ) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                f[i][1] = f[i - 1][0] + a[i];
            }

            System.out.println(Math.max(f[n][0], f[n][1]));
        }
    }
}