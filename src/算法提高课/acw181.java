package 算法提高课;

import java.util.Scanner;

// 本题听起来非常简单, 但是实现起来我觉得难度还是有的

/*
    首先根据题目说明给整个地图的格子手动编号
             (A)   (B)
              0     1
              2     3
    (H) 4  5  6  7  8  9  10 (C)
              11    12
    (G) 13 14 15 16 17 18 19 (D)
              20    21
              22    23
              (F)   (E)
*/

public class acw181 {
    static int[] q = new int[30]; // 存放数据输入的操作序列

    // 手动打表将操作序列放出来 其中A -> op[0], B -> op[1], ...
    static int[][] op = {
            {0, 2, 6, 11, 15, 20, 22},
            {1, 3, 8, 12, 17, 21, 23},
            {10, 9, 8, 7, 6, 5, 4},
            {19, 18, 17, 16, 15, 14, 13},
            {23, 21, 17, 12, 8, 3, 1},
            {22, 20, 15, 11, 6, 2, 0},
            {13, 14, 15, 16, 17, 18, 19},
            {4, 5, 6, 7, 8, 9, 10}
    };

    static int[] center = {6, 7, 8, 11, 12, 15, 16, 17}; //中间的8个格子
    static int[] opposite = {5, 4, 7, 6, 1, 0, 3, 2}; // 每种操作对应的反操作 (剪枝用), 比如 A的反操作 对应 F, 那么op[0] 对应的就是 op[5], 其中用opposite[0] == 5记录下来, 往后依次类推
    static int[] path = new int[100]; // 存放答案的路径

    private static int f() { // 估价函数 : 中间格子估计最少需要几步可以走到答案, 拿8减去出现次数最多数的次数
        int[] sum = new int[4]; // 用来存放中间8个格子1, 2, 3出现的次数
        for (int i = 0; i < 8; i ++ ) sum[q[center[i]]] ++ ; // 格子的值根据题意只有1, 2, 3

        int s = 0;
        for (int i = 1; i <= 3; i ++ ) s = Math.max(s, sum[i]); // 找出中间格子中出现次数最多的数的次数
        return 8 - s; // 进行股价
    }

    private static void operation(int x) { // 模拟实现题意描述的操作
        int t = q[op[x][0]];
        for (int i = 0; i < 6; i ++ ) q[op[x][i]] = q[op[x][i + 1]];
        q[op[x][6]] = t;
    }


    // dep : 我当前执行的次数 我当前所在的层数
    // max_dep: 我最多执行的操作次数max_dep, 同时也是设置的搜索最大深度
    // last : 上一次(层)的操作是last
    private static boolean dfs(int dep, int max_dep, int last) { // IDA*
        if (dep + f() > max_dep) return false; // IDA*对应的类似剪枝的操作, 如果当前状态怎么搜都超过我设置的最大限度, 那就减掉
        if (f() == 0) return true; // 搜到了答案

        for (int i = 0; i < 8; i ++ ) {
            if (opposite[i] == last) continue; // 剪枝, 如果这一步是上一步的反操作, 那就剪掉
            operation(i); // 进行i操作
            path[dep] = i; // 记录答案
            if (dfs(dep + 1, max_dep, i)) return true; // 往下搜索
            operation(opposite[i]); // 恢复现场 -> 操作回来
            // 不再写path的原因是path是直接被覆盖的
        }

        return false;
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (sc.hasNext()) {
            // 读取数据
            for (int i = 0; i < 24; i ++ ) {
                q[i] = sc.nextInt();
                if (q[i] == 0) return ;
            }
            int dep = 0;
            while (!dfs(0, dep, -1)) dep ++ ; // 利用IDA*求解

            // 根据题意输出结果
            if (dep == 0) System.out.println("No moves needed\n" + q[6]);
            else {
                for (int i = 0; i < dep; i ++ ) System.out.print((char)('A' + path[i]));
                System.out.println("\n" + q[6]);
            }
        }
    }
}
