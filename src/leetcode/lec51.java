package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lec51 {
    List<List<String>> ans = new ArrayList<>();
    Set<Integer> sty = new HashSet<>();
    Set<Integer> stz = new HashSet<>();
    Set<Integer> stc = new HashSet<>();

    int n;
    public List<List<String>> solveNQueens(int _n) {
        n = _n;
        List<StringBuilder> lis = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i ++ ) sb.append('.');
        for (int i = 1; i <= n; i ++ ) lis.add(sb);

//        System.out.println(lis);

        dfs(0, lis);
        return ans;
    }

    public void dfs(int now, List<StringBuilder> list) {
        List<StringBuilder> temp = new ArrayList<>(list);
        if (now == n) {
            List<String> e = new ArrayList<>();
            for (StringBuilder x : temp) e.add(x.toString());
            ans.add(e);
            return ;
        }

        for (int i = 0; i < n; i ++ ) {
            if (sty.contains(i) || stz.contains(now - i) || stc.contains(-now - i)) continue;
            StringBuilder yu = new StringBuilder(temp.get(now));
            StringBuilder ba = new StringBuilder(temp.get(now));
            ba.setCharAt(i, 'Q');
            temp.set(now, ba);
            sty.add(i);
            stz.add(now - i);
            stc.add(-now - i);
            dfs(now + 1, temp);
            temp.set(now, yu);
            sty.remove(i);
            stz.remove(now - i);
            stc.remove(-now - i);
        }
    }
}
