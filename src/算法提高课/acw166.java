package 算法提高课;

import java.util.Scanner;

public class acw166 {
    static StringBuilder str;
    static final int N = 9, M = 1 << N;
    static int[] ones = new int[M], map = new int[M]; // ones[i]代表这个数的二进制表示中有几个1, map[i]代表 2^i 的i是谁
    static int[] row = new int[N], col = new int[N]; // row和col分别代表整个数独的第i行和第j列
    static int[][] g = new int[3][3]; // g[i][j]代表第i个和第j个九宫格

    private static void init() { // 初始化row, col, g
        // 二进制数的某一个位为1代表可选, 为0代表不可选, 比如 :
        //       二进制数111_111_111代表 [1 -> 9] 都可以选
        //       二进制数111_000_110代表 [2, 3, 7, 8, 9] 可以选
        for (int i = 0; i < N; i ++ ) {
            row[i] = (1 << N) - 1;
            col[i] = (1 << N) - 1;
        }

        for (int i = 0; i < 3; i ++ )
            for (int j = 0; j < 3; j ++ )
                g[i][j] = (1 << N) - 1;
    }

    private static void draw(int x, int y, int t, boolean is_set) { // 辅助函数
        // 代表数独中第x行第j列的数, 如果is_set是true, 那就把t填到对应位置, 如果是false那就是把对应位置上的t删除 (删除主要是回溯用的)
        if (is_set) str.setCharAt(x * N + y, (char) ('1' + t)); // 注意映射一下, 数独中第x行第j列对应str中的位置是x * N + y (下标问题不再赘述, 自己考虑去)
        else str.setCharAt(x * N + y, '.');

        int v = 1 << t; // 修改数独的同时也需要修改row, col, g
        if (!is_set) v = -v; // 如果是填, 那就减去v, 让二进制对应位置成0, 如果是删, 那就加上v, 让二进制对应位置成1

        row[x] -= v;
        col[y] -= v;
        g[x / 3][y / 3] -= v;
    }

    private static int lowbit(int x) { // 你好
        return (x) & (-x);
    }

    private static int get(int x, int y) { // 快速得到在 这一行, 这一列, 这个位置所在九宫格 三个条件约束下哪些数可以选
        // 其实就是按位与一下
        return row[x] & col[y] & g[x / 3][y / 3];
        // 比如 :
        //      row[x]           : 101010101
        //      col[y]           : 100100100
        //      g[x / 3][y / 3]  : 111011101
        // 最终得到这个位置能填的数是 : 100000100 也就是 [3, 9]
    }

    private static boolean dfs(int cnt) { // 搜索
        if (cnt == 0) return true;

        int minv = 0x3f3f3f3f;
        int x = 0, y = 0;
        for (int i = 0; i < N; i ++ )
            for (int j = 0; j < N; j ++ )
                if (str.charAt(i * N + j) == '.') { // 优化搜索顺序 -> 先搜分支较小的
                    int state = get(i, j);
                    if (ones[state] < minv) {
                        minv = ones[state];
                        x = i; y = j;
                    }
                }

        int state = get(x, y);
        for (int i = state; i != 0; i -= lowbit(i)) {
            int t = map[lowbit(i)];
            draw(x, y, t, true); // 在这个位置填上可以填上的数
            if (dfs(cnt - 1)) return true; // 往下搜索
            draw(x, y, t, false); // 回溯
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i ++ ) map[1 << i] = i; // 快速得到当前 2^i 的i是谁, 比如 : 2^1 == 10 (二进制), 2^3 == 100 (二进制)
        for (int i = 0; i < (1 << N); i ++ )
            for (int j = 0; j < N; j ++ )
                ones[i] += (i >> j) & 1;

        while (sc.hasNext()) {
            str = new StringBuilder(sc.next());
            if ("end".contentEquals(str)) return ;

            init();
            int cnt = 0;
            for (int i = 0, k = 0; i < N; i ++ ) // i, j表示数组中i行第j列, k表示[i, j]对应在str中的位置 (我靠, 这个循环有点小厉害)
                for (int j = 0; j < N; j ++ , k ++ )
                    if (str.charAt(k) != '.') {
                        int t = str.charAt(k) - '1';
                        draw(i, j, t, true);
                    } else cnt ++ ; // 计算有多少个位置需要填

//            System.out.println(cnt);
            dfs(cnt);
            System.out.println(str);
        }
    }
}
