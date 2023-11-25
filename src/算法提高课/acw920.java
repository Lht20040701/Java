package 算法提高课;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class acw920 {
    static int m, n;
    static boolean[][] g;
    static int[] d;
    static int[] stop;

    private static void init() {
        g = new boolean[n + 10][n + 10]; stop = new int[n + 10]; d = new int[n + 10];
        Arrays.fill(d, 0x3f3f3f3f);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        d[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i = 1; i <= n; i ++ )
                if (g[t][i] && d[i] > d[t] + 1) {
                    d[i] = d[t] + 1;
                    q.add(i);
                }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); n = sc.nextInt();
        init();

        sc.nextLine();
        for (int i = 1; i <= m; i ++ ) {
            int idx = 0;
            String str = sc.nextLine();
            Scanner sin = new Scanner(str);
            while (sin.hasNext()) stop[idx ++ ] = sin.nextInt();
            for (int j = 0; j < idx; j ++ )
                for (int k = j + 1; k < idx ; k ++ )
                    g[stop[j]][stop[k]] = true;
        }

        bfs();

        if (d[n] == 0x3f3f3f3f) System.out.println("NO");
        else System.out.println(Math.max(d[n] - 1, 0));
    }
}
