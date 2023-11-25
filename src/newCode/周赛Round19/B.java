package newCode.周赛Round19;

import java.util.Scanner;

public class B {
    static int a, b, x, y;
    static int ans = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt(); b = sc.nextInt(); x = sc.nextInt(); y = sc.nextInt();

        dfs(0, a, b);
        System.out.println(ans);
    }

    public static void dfs(int cnt, int xx, int yy) {
        if (xx <= 0 && yy <= 0) {
            ans = Math.min(ans, cnt);
            return ;
        }

        if (xx > 0 && y < x) dfs(cnt + 1, xx - x, yy);
        if (yy > 0 && y < x) dfs(cnt + 1, xx, yy - x);
        dfs(cnt + 1, xx - y, yy - y);
    }
}
