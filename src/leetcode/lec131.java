package leetcode;
import java.util.ArrayList;
import java.util.List;

public class lec131 {
    List<List<String>> ans = new ArrayList<>();
    String s;

    public List<List<String>> partition(String _s) {
        s = _s;
        dfs(0, new ArrayList<>());
        return ans;
    }

    public void dfs(int nowL, List<String> lis) {
        if (nowL == s.length()) {
            ans.add(lis);
            return ;
        }

        for (int i = nowL + 1; i <= s.length(); i ++ ) {
            List<String> temp = new ArrayList<>(lis);
            String t = s.substring(nowL, i);
            if (!check(t)) continue;
            temp.add(t);
            dfs(i, temp);
        }
    }

    public boolean check(String t) {
        StringBuilder sb = new StringBuilder(t);
        sb.reverse();
        return t.contentEquals(sb);
    }
}
