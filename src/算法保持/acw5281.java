package 算法保持;

import java.util.Scanner;

public class acw5281 {
    /*
    * 比较坑的地方在于 下表是从1开始的, 导致对k处理的时候非常蛋疼, 其实只用charAt的时候减1就好了, 递归的时候第二个参数不用减1
    * */

    static String s0 = "DKER EPH VOS GOLNJ ER RKH HNG OI RKH UOPMGB CPH VOS FSQVB DLMM VOS QETH SQB";
    static String s1 = "DKER EPH VOS GOLNJ UKLMH QHNGLNJ A";
    static String s2 = "AB CPH VOS FSQVB DLMM VOS QHNG A";
    static String s3 = "AB";
    static long[] slen = new long[100010];

    public static long getSlen(int n) {
        if (slen[n] != 0) return slen[n];
        if (n == 0) return slen[0] = s0.length();
        else {
//            return slen[n] = s1.length() +  getSlen(n - 1) + s2.length() + getSlen(n - 1) + s3.length();
//            return slen[n] = Math.min(s1.length() +  getSlen(n - 1) + s2.length() + getSlen(n - 1) + s3.length(), (long)2e18);
            slen[n] += s1.length();
            slen[n] += getSlen(n - 1);
            if (slen[n] >= 2e18) return slen[n] = (long)2e18;
            slen[n] += s2.length();
            if (slen[n] >= 2e18) return slen[n] = (long)2e18;
            slen[n] += getSlen(n - 1);
            if (slen[n] >= 2e18) return slen[n] = (long)2e18;
            slen[n] += s3.length();
            if (slen[n] >= 2e18) return slen[n] = (long)2e18;
            return slen[n];
        }
    }

    public static char dfs_Memory(int n, long k) {
        if (getSlen(n) < k) return '.';
        if (n == 0) return s0.charAt((int)(k - 1));
        else {
            if (k <= s1.length()) return s1.charAt((int)k - 1);
            else if (k <= s1.length() + getSlen(n - 1)) return dfs_Memory(n - 1, k - s1.length());
            else if (k <= s1.length() + getSlen(n - 1) + s2.length()) return s2.charAt((int)(k - s1.length() - getSlen(n - 1) - 1));
            else if (k <= s1.length() + getSlen(n - 1) + s2.length() + getSlen(n - 1)) return dfs_Memory(n - 1, k - s1.length() - getSlen(n - 1) - s2.length());
            else return s3.charAt((int)(k - s1.length() - getSlen(n - 1) - s2.length() - getSlen(n - 1) - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println(s0.length() + " " + s1.length() + " " + s2.length() + " " + s3.length()); // 75 34 32 2
//        System.out.println(s0.charAt(52));

        int q = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (q -- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
//            System.out.println(getSlen(n));
            ans.append(dfs_Memory(n, k));
        }

        System.out.println(ans.toString());
    }
}
