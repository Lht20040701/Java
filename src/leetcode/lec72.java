package leetcode;

public class lec72 {
    public int minDistance(String word1, String word2) {
        String a = " " + word1;
        String b = " " + word2;
        int n = word1.length(), m = word2.length();

        int[][] f = new int[n + 10][m + 10];
        for (int i = 0; i <= n; i ++ ) f[i][0] = i;
        for (int i = 0; i <= m; i ++ ) f[0][i] = i;

        System.out.println(a + " " + n);
        System.out.println(b + " " + m);

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= m; j ++ ) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (a.charAt(i) == b.charAt(j)) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                else f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
            }
        }

        return f[n][m];
    }
}
