package leetcode;

public class lec1698 {
    public static void main(String[] args) {
//        System.out.println(dfs(9, "81", 0, 0, 0));
        System.out.println(punishmentNumber(37));
    }
    public static int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i ++ ) if (dfs(i, String.valueOf(i * i), 0, 0, 0)) ans += i * i;
        return ans;
    }

    // x代表当前的枚举的i, s代表i * i的字符串形式, nowSum表示求到目前的和, now代表我当前正在凑的数字, w代表我搜到s的哪个位置了
    static boolean dfs(int x, String s, int nowSum, int now, int w) {
        if (nowSum > x) return false;
        if (now > x) return false;
        if (w == s.length()) {
            nowSum += now; // 到头以后now是最后一个凑好的数字, 需要放到nowSum中
            return nowSum == x;
        }

        // 两个分支 : 1. 把当前凑好的数字给nowSum, 然后新开一个数字
        //           2. 继续凑数字
        //           两个分支只要有一个是true就行, 所以用或连接
        boolean f = dfs(x, s, nowSum + now, s.charAt(w) - '0', w + 1) ||
                dfs(x, s, nowSum, now * 10 + s.charAt(w) - '0', w + 1);

        return f;
    }
}
