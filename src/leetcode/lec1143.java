package leetcode;

public class lec1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        String a = " " + text1;
        String b = " " + text2;
        int n = text1.length(), m = text2.length();

        int[][] f = new int[n + 10][m + 10];
        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a.charAt(i) == b.charAt(j)) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }

        return f[n][m];
    }
}
