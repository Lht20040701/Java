package 算法提高课;

import java.util.Scanner;

public class acw170 {

    /**
     * 迭代加深是什么 : 设定一个最大搜索层数dep, 逐步扩大这个搜索层数dep来寻找答案的深搜就是迭代加深 (可以看成先把层数超过dep的分支全给剪掉了
     * 迭代加深题目的特点 : 所有可行方案中某一个分支特别的深, 但是我们答案所在的层数特别靠上, 这时候就可以用迭代加深
     * 可能会有疑问 : 我如果这次搜索没搜到答案, 我扩大范围后再重新搜索不就把刚刚搜索过的又重新搜了一遍吗 ?
     *               答 : 可以自己算一下, 当为满树的情况时, 我们最后一层节点要比上面所有节点数要多, 所以搜的多的情况下可以不计 (写的可能有点歧义, 我感觉这个不用太在意其实, 知道这种写法就好
     * 为什么本题符合迭代加深 :
     *           以n == 128为例
     *           1. 所有可行方案中某一个分支特别的深, 比如1, 2, 3, 4, 5 ... 128
     *           2. 但是答案所在的层数特别靠上, 即 : 1, 2, 4, 8, 16, 32, 64, 128
     *           综上, 符合我们的特征
     *
     *           我们为了让我们的答案更优, 应该加入一些剪枝
     *                  1. 优化搜索顺序, 先枚举大的, 虽然大的不一定对, 但是仍然可以去除大部分的枝
     *                  2. 去除冗余分支, 比如5 == 1 + 4 == 2 + 3, 我们为了避免重复搜索, 应该记录这层中这个值是否已经作为一个节点存在了
     *                  3. 在刚刚的基础上, 我们的path应该符合题目要求
     * */
    static int[] path;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            n = sc.nextInt();
            if (n == 0) break;
            path = new int[n + 10];
            path[0] = 1; // 根据题意答案path的最开头一定是1

            int dep = 1;
            while (!dfs(1, dep)) dep ++ ; // 逐渐扩大搜索层数
            for (int i = 0; i < dep; i ++ ) System.out.print(path[i] + " "); // 输出答案
            System.out.println();
        }
    }

    public static boolean dfs(int u, int dep) { // u代表我当前枚举的path的哪个位置, dep表示我path的最长长度, 也就是搜索树的最大层数
        if (u > dep) return false; // 超过了规定的搜索的最大层数就false
        if (path[dep - 1] == n) return true; // 如果找到了答案就返回true
        boolean[] st = new boolean[n + 10]; // 剪枝2 : 去掉冗余

        for (int i = u - 1; i >= 0; i -- ) { // 剪枝1 : 优化搜索顺序
            for (int j = i; j >= 0; j -- ) {
                int s = path[i] + path[j];
                if (s > n || s <= path[u - 1] || st[s]) continue; // 进行剪枝并且让我们的答案符合题目要求

                st[s] = true;
                path[u] = s; // 记录路径 (因为赋值是直接覆盖的所以没写恢复现场的操作
                if (dfs(u + 1, dep)) return true; // 连锁 : 往下搜的过程中找到了答案, 就返回true
            }
        }
        return false; // 所有情况都讨论了, 还是没答案, 返回false
    }
}
