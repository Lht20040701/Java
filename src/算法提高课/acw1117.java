package 算法提高课;

import java.util.Scanner;

public class acw1117 {
    static String[] word;
    static int n;
    static int[] used;
    static int[][] g;
    static int ans;
    /**
     * 思路 :
     *          本题主要锻炼的是dfs的搜索顺序 -> 也就是如何去搜索, 把一个题目转化成我们的搜索问题 (感觉对打暴力也有好处
     *          g[i][j] : 表示第i个单词在前, 第j个单词在后, 他们公共的部分有多长
     *          used[i] : 表示第i个单词用了几次
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        word = new String[n + 10];
        g = new int[n + 10][n + 10];
        used = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) word[i] = sc.next();

        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j++) {
                int len = Math.min(word[i].length(), word[j].length());
                for (int k = 1; k < len; k++)
                    if (word[i].substring(word[i].length() - k).equals(word[j].substring(0, k))) {
                        g[i][j] = k;
                        break;
                    }
            }

        String st = sc.next();
        for (int i = 1; i <= n; i ++ )
            if (word[i].startsWith(st))
                dfs(new StringBuilder(word[i]), i);

        System.out.println(ans);
    }

    private static void dfs(StringBuilder dargon, int last) { // dargon表示我当前的龙, last表示龙目前末尾的单词编号
        ans = Math.max(ans, dargon.length());
        used[last] ++ ;

        for (int i = 1; i <= n; i ++ )
            if (used[i] < 2 && g[last][i] != 0) {
                StringBuilder sb = new StringBuilder(dargon.toString());
                sb.append(word[i].substring(g[last][i]));
                dfs(sb, i);
            }

        used[last] -- ;
    }
}
