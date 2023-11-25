package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw167 {
    static int[] w;
    static boolean[] st;
    static int sum, len, n;

    /**
     * 本题剪枝比较多光介绍一下, 本代码注释光介绍一下剪枝的大概思路, 如果有遗忘或者想要证明, 第一首选还是看题解和视频
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            n = sc.nextInt();
            if (n == 0) break;
            sum = 0;
            w = new int[n + 10]; st = new boolean[n + 10];

            for (int i = 1; i <= n; i ++ ) {
                w[i] = sc.nextInt();
                sum += w[i];
            }

            // 剪枝1 : 优化搜索顺序, 先枚举长的小木棍
            Arrays.sort(w, 1, 1 + n);
            reverse();

            len = 1;
            while (true) {
                // 剪枝2 : 可行性剪枝, 只有总长度是每一个长木棍的长度len的倍数的时候才会是答案
                if (sum % len == 0 && dfs(0, 0, 1)) {
                    System.out.println(len);
                    break;
                }
                len ++ ;
            }
        }
    }

    // 拼好了的u根长棍, 正在拼第u + 1根长棍, 当前长棍拼了cur长, 从start开始枚举小棍子
    private static boolean dfs(int u, int cur, int start) {
        if (u * len == sum) return true; // 长棍子都拼好的条件是 -> 长棍子的长度 * 拼好的根数 == 总长度
        if (cur == len) return dfs(u + 1, 0, 1);

        for (int i = start; i <= n; i ++ ) {
            if (st[i] || cur + w[i] > len) continue; // 如果这个棍子被用过了, 或者长度太长, 我们就不用

            st[i] = true;
            if (dfs(u, cur + w[i], i + 1)) return true; // 往下搜看这种方法成功不成功, 成功了就返回true,不成功就是走下面的看能不能剪枝
            st[i] = false;

            // 走到这里了就说明上面放棍子放失败了
            if (cur == 0 || cur + w[i] == len) return false; // 剪枝3 : 如果是我这根棍子放的位置是 第一根棍子 或者 末尾的最后一根棍子 的位置且无解, 那目前的方法就不可能有解, 直接返回false
            // 这里的证明太刁了, 可以看视频或者题解

            int j = i;
            while (j <= n && w[j] == w[i]) j ++ ; // 剪枝4 : 排除等效冗余, 因为长度是降序, 并且如果我这根小棍子放了没解, 那和我一样长的小棍子放了同样无解
            i = j - 1; // 具体证明见视频或者题解
        }

        return false;
    }

    private static void reverse() {
        for (int i = 1, j = n; i < j; i ++ , j -- ) {
            int t = w[i];
            w[i] = w[j];
            w[j] = t;
        }
    }
}
