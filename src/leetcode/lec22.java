package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec22 {
    int n;
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int _n) {
        n = _n;
        dfs(1, 0, new StringBuilder());
        return ans;
    }

    public void dfs(int u, int cnt, StringBuilder sb) { // u代表我目前放到哪一个括号了, cnt表示最前面的嵌套括号有几层, sb表示当前字符串
        if (u == n + 1) {
            String x = sb.toString();
            if (!ans.contains(x)) ans.add(x);
            return ;
        }

        for (int i = 0; i <= cnt; i ++ ) {
            StringBuilder _sb = new StringBuilder(sb.toString());
            _sb.insert(i, "()");
            dfs(u + 1, cnt + 1, _sb);
        }
    }
}
