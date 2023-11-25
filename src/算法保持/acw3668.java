package 算法保持;

import java.util.Scanner;

public class acw3668 {
    //                       右 下  左  上

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int w;
            int h;
            char[][] ch = new char[20][20];
            boolean[][] bo = new boolean[20][20];
            int sx = 1, sy = 1;
            char st = ' ';
            int ans = 0;

            final int[] dx = {0, 1, 0, -1};
            final int[] dy = {1, 0, -1, 0};

            w = sc.nextInt();
            h = sc.nextInt();

//            for (int i = 1; i <= w; i ++ ) {
//                for (int j = 1; j <= h; j ++ ) {
//                    bo[i][j] = false;
//                }
//            }
//            ans = 0;

            for (int i = 1; i <= w; i ++ ) {
                String s = sc.next();
                s = " " + s;
                for (int j = 1; j <= h; j ++ ) {
                    if (s.charAt(j) == 'U' || s.charAt(j) == 'R' || s.charAt(j) == 'D' || s.charAt(j) == 'L') {
                        sx = i;
                        sy = j;
//                        bo[sx][sy] = true;
//                        ans ++ ;
                        st = s.charAt(j);
                    }
                    ch[i][j] = s.charAt(j);
                }
            }

//            for (int i = 1; i <= w; i ++ ) {
//                for (int j = 1; j <= h; j ++ ) {
//                    System.out.print(ch[i][j] + " ");
//                }
//                System.out.println("");
//            }

            int fr;

            if (st == 'U') fr = 3;
            else if (st == 'R') fr = 0;
            else if (st == 'L') fr = 2;
            else fr = 1;

            while (!bo[sx][sy]) {
                bo[sx][sy] = true;
                ans ++ ;
//                System.out.println("debug");

                int a = sx + dx[fr];
                int b = sy + dy[fr];

                boolean f = false;
                if (a < 1 || a > w || b < 1 || b > h || bo[a][b] || ch[a][b] == '*') {
                    fr = (fr + 1) % 4;
                    a = sx + dx[fr];
                    b = sy + dy[fr];
                    f = true;
                }
                sx = a;
                sy = b;

                if (a < 1 || a > w || b < 1 || b > h || bo[a][b]) break;
                if (f && ch[a][b] == '*') break;
                if (f && bo[a][b]) break;

//                System.out.println(a + " " + b);
            }

            System.out.println(ans);

        }
    }
}
