package newCode.周赛Round20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_solution2 {
    static int la, lb;
    static int ans = 0x3f3f3f3f;
    static String a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next(); b = sc.next();
        la = a.length(); lb = b.length();

        dfsA(0, new ArrayList<>(), 0);
        if (ans != 0x3f3f3f3f) System.out.println(ans);
        else System.out.println(-1);
    }

    private static int get(List<Integer> lis) {
        int len = lis.size(), ret = 0;
        for (int i = 0; i < len; i ++ ) ret = ret * 10 + lis.get(i);
        return ret;
    }

    private static boolean check(int a, int b) {
        if (a == 0 || b == 0) return false;
        return a % b == 0 || b % a == 0;
    }

    private static void dfsA(int len, List<Integer> lis, int del) {
        if (len == la) {
            dfsB(0, new ArrayList<>(), 0, lis, del); // 两个dfs连起来的地方
            return ;
        }
        dfsA(len + 1, lis, del + 1); // 删除

        lis.add(a.charAt(len) - '0');
        dfsA(len + 1, lis, del); // 不删
        lis.remove(lis.size() - 1);
    }

    private static void dfsB(int len, List<Integer> lisB, int delB, List<Integer> lisA, int delA) { // 继承dfsA的结果
        if (len == lb) {
            int x = get(lisA), y = get(lisB);
            if (check(x, y)) ans = Math.min(ans, delA + delB);
            return ;
        }

        dfsB(len + 1, lisB, delB + 1, lisA, delA); // 删除

        lisB.add(b.charAt(len) - '0');
        dfsB(len + 1, lisB, delB, lisA, delA); // 不删除
        lisB.remove(lisB.size() - 1);

    }
}
