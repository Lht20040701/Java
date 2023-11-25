package 算法提高课;

import java.util.*;

public class acw1107 {

    /**
     * 思路比较简单 : 只需要将每一个图都看成一个点(状态), 然后用bfs跑遍所有状态就能找到符合题目要求的最小步骤了
     * 实现比较难 : 和八数码一样, 都属于最小步数模型中的题目, 思路简单的前提就是实现起来是有一定难度的
     *            本题具体如何实现的, 看代码注释
     *            还有就是好好题, 题目直接就说了把一个状态顺时针转化为字符串
     * */
    static class PCS { // 给pre用的, 把上一步的到下一步的操作和上一步的状态打包一起
        char op;
        String s;
        public PCS(char op, String s) {
            this.op = op;
            this.s = s;
        }
    }
    static char[][] g = new char[2][4]; // 给ABC三种操作用的
    static Map<String, Integer> dist = new HashMap<>(); // bfs用的dist数组 -> 走到当前状态String需要花费的操作数Integer
    static Map<String, PCS> pre = new HashMap<>(); // 当前状态String的上一步是什么状态PCS.s, 以及上一步怎么走到当前状态的PCS.op

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder start = new StringBuilder(), end = new StringBuilder();
        for (int i = 0; i < 8; i ++ ) {
            int x = sc.nextInt();
            end.append((char)(x + '0')); // 将输入转化为字符串
        }

        for (int i = 0; i < 8; i ++ ) start.append((char)(i + '1')); // 起始状态
        int step = bfs(start, end); // 算出答案
        System.out.println(step); // 输出答案

        StringBuilder res = new StringBuilder();
        while (!end.toString().contentEquals(start)) { // 通过回溯得到步骤
//            System.out.println("debug -> " + end);
            res.append(pre.get(end.toString()).op);
            end = new StringBuilder(pre.get(end.toString()).s);
        }
        res.reverse(); // 因为回溯得到的是逆序, 所以转回来
        if (step > 0) System.out.println(res);
    }

    public static int bfs(StringBuilder start, StringBuilder end) {
        if (start.toString().contentEquals(end)) return 0; // 刚开始就一样的话直接退出来就好了

        Queue<String> q = new LinkedList<>(); // q存的是每一个状态
        q.add(start.toString());
        dist.put(start.toString(), 0);

        while (!q.isEmpty()) {
            String t = q.poll();
            String[] m = new String[3]; // m[i]记录从当前状态t经过三种操作后的状态
            m[0] = moveA(t);
            m[1] = moveB(t);
            m[2] = moveC(t);

            for (int i = 0; i < 3; i ++ ) {
                if (!dist.containsKey(m[i])) { // 根据bfs特性 : 如果一个状态之前走过了, 那他的最小步数就确定了, 当前答案一定不是最优, 跳过就好了
                    dist.put(m[i], dist.get(t) + 1); // 得到m[i]的答案 -> dist.get(t) + 1
                    pre.put(m[i], new PCS((char)('A' + i), t)); // 将m[i]的上一步状态和操作记录下来
                    q.add(m[i]); // 当前状态入队
                    if (m[i].contentEquals(end)) return dist.get(end.toString()); // 搜索到了答案
                }
            }
        }

        return -1; // 垃圾值 : 因为说了必定有解
    }

    public static void set(String state) { // 将该状态state放到字符数组g[2][4]以便三种操作
        for (int i = 0; i < 4; i ++ ) g[0][i] = state.charAt(i);
        for (int i = 7, j = 0; j < 4; j ++, i -- ) g[1][j] = state.charAt(i);
    }

    public static String get() { // 经过三种操作变形后, 再把字符数组g[2][4]转化为我们存的状态String state
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 4; i ++ ) ret.append(g[0][i]);
        for (int i = 3; i >= 0; i -- ) ret.append(g[1][i]);
        return ret.toString();
    }

    public static String moveA(String state) { // 操作A : 上下翻转
        set(state);
        for (int i = 0; i < 4; i ++ ) swap(0, i, 1, i); // 手写swap方法 : 不想多写一个函数就写里面, 看个人爱好
        return get();
    }

    public static String moveB(String state) { // 操作B : 将最右侧一列放到第一列
        set(state);
        char v0 = g[0][3], v1 = g[1][3];
        for (int i = 3; i > 0; i -- ) {
            g[0][i] = g[0][i - 1];
            g[1][i] = g[1][i - 1];
        }
        g[0][0] = v0; g[1][0] = v1;
        return get();
    }

    public static String moveC(String state) { // 操作C : 中间四个顺时针旋转一下
        set(state);
        char v = g[0][1];
        g[0][1] = g[1][1];
        g[1][1] = g[1][2];
        g[1][2] = g[0][2];
        g[0][2] = v;
        return get();
    }

    public static void swap(int a, int b, int x, int y) { // 将g[a][b]和g[x][y]交换
        char t = g[a][b];
        g[a][b] = g[x][y];
        g[x][y] = t;
    }
}
