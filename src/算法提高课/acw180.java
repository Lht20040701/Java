package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw180 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] q; // 当前状态

    private static int f() { // 计算当前状态的估价函数 (根据后继关系推过来)
        int cnt = 0;
        for (int i = 1; i + 1 <= n; i ++ )
            if (q[i + 1] != q[i] + 1)
                cnt ++ ;

        return (cnt + 2) / 3;
    }

    // dep : 我当前进行操作的次数, 也可以说我当前所在的层数
    // max_dep : 我设置的最大操作次数, 也可以是说是最大的搜索层数
    private static boolean dfs(int dep, int max_dep) {
        if (dep + f() > max_dep) return false; // 当前状态无论怎么搜都会超出层数上限, 可以退出来了就 (感觉之所以IDA*可以过就是这里是关键的一步, 利用 迭代加深和估价函数 进行的类似于剪枝的操作)
        if (f() == 0) return true; // 搜索到答案


        for (int len = 1; len <= n; len ++ ) // 枚举交换的长度
            for (int l = 1; l + len - 1 <= n; l++) { // 可以交换部分的左边界
                int r = l + len - 1;
                for (int k = r + 1; k <= n; k++) { // 枚举插入点
                    int[] bk = Arrays.copyOf(q, n + 10); // 备份数组bk, 因为是基本数据类型所以直接Arrays.copyOf了

                    // 利用备份数组进行插入操作的模拟
                    int x, y;
                    for (x = r + 1, y = l; x <= k; x++, y++) q[y] = bk[x];
                    for (x = l; x <= r; x++, y++) q[y] = bk[x];
                    //

                    if (dfs(dep + 1, max_dep)) return true; // 继续往下搜

                    for (int i = 1; i <= n; i++) q[i] = bk[i]; // 恢复现场
                }
            }

        return false;
    }

    private static void solve() {
        n = sc.nextInt();
        q = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) q[i] = sc.nextInt();

        int dep = 0;
        while (dep <= 4 && !dfs(0, dep)) dep ++ ; // 迭代加深

        // 根据题意输出答案
        if (dep <= 4) System.out.println(dep);
        else System.out.println("5 or more");
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        while (T -- > 0) solve();
    }
}
