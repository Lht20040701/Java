package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec17 {
    public static void main(String[] args) {

    }

    ArrayList<char[]> lis = new ArrayList<>();

    public void init() {
        lis.add(null);
        lis.add(null);
        lis.add(new char[] {'a', 'b', 'c'});        // 2
        lis.add(new char[] {'d', 'e', 'f'});        // 3
        lis.add(new char[] {'g', 'h', 'i'});        // 4
        lis.add(new char[] {'j', 'k', 'l'});        // 5
        lis.add(new char[] {'m', 'n', 'o'});        // 6
        lis.add(new char[] {'p', 'q', 'r', 's'});   // 7
        lis.add(new char[] {'t', 'u', 'v'});        // 8
        lis.add(new char[] {'w', 'x', 'y', 'z'});   // 9
    }

    public List<String> letterCombinations(String digits) {

        init();
        ArrayList<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        dfs(digits, new StringBuilder(), 0, ans);
        return ans;
    }

    public void dfs(String digits, StringBuilder now, int u, ArrayList<String> ans) { // u代表已经放好了几个字母
        if (u == digits.length()) {
            ans.add(now.toString());
            return ;
        }

        int len = lis.get(digits.charAt(u) - '0').length;

        for (int i = 0; i < len; i ++ ) {
            StringBuilder nows = new StringBuilder(now.toString());
            nows.append(lis.get(digits.charAt(u) - '0')[i]);
            dfs(digits, nows, u + 1, ans);
        }
    }
}
