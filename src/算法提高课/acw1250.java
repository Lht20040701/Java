package 算法提高课;

import java.util.Scanner;

public class acw1250 {
    static int n, m;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        p = new int[n * m + 10];

        for (int i = 1; i <= n * m; i ++ ) p[i] = i;

        for (int i = 1; i <= m; i ++ ) {
            int x = sc.nextInt(), y = sc.nextInt();

            int pnode = find(swap(x, y));
            String op = sc.next();
            int pnext = 0;
            if ("R".equals(op)) pnext = find(swap(x, y + 1));
            else pnext = find(swap(x + 1, y));

            if (pnode != pnext) p[pnode] = pnext;
            else {
                System.out.println(i);
                return ;
            }
        }

        System.out.println("draw");
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static int swap(int x, int y) {
        return (x - 1) * m + y;
    }
}
