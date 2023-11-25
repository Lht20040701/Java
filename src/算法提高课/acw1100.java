package 算法提高课;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class acw1100 {
    static int n, k;
    static int ans = 0x3f3f3f3f;
    static int[] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt();
        vis = new int[100010];
        Arrays.fill(vis, -1);
        System.out.println(bfs(n));
    }

    public static int bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        vis[a] = 0;

        while (!q.isEmpty()) {
            int t = q.poll();
            if (t * 2 < 100010 && vis[t * 2] == -1) {
                q.add(t * 2);
                vis[t * 2] = vis[t] + 1;
            }

            if (t + 1 < 100010 && vis[t + 1] == -1) {
                q.add(t + 1);
                vis[t + 1] = vis[t] + 1;
            }

            if (t - 1 >= 0 && vis[t - 1] == -1) {
                q.add(t - 1);
                vis[t - 1] = vis[t] + 1;
            }

            if (t + 1 == k || t * 2 == k || t - 1 == k) break;
        }

        return vis[k];
    }
}
