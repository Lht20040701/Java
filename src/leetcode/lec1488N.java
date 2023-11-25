package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class lec1488N {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> ts = new TreeSet<>();
        HashMap<Integer, Integer> m = new HashMap<>();

        int[] ans = new int[rains.length];
        Arrays.fill(rains, 1);

        /**
         * 题解 : https://leetcode.cn/problems/avoid-flood-in-the-city/solutions/2480169/javapython3ctan-xin-er-fen-cha-zhao-xun-dkgpe/
         * */

        for (int i = 0; i < rains.length; i ++ ) {
            if (rains[i] == 0) {
                ts.add(i);
            } else {
                ans[i] = -1;
                if (m.containsKey(rains[i])) {
                    Integer fr = ts.ceiling(m.get(rains[i]));
                    if (fr != null) {
                        ts.remove(fr);
                        ans[i] = rains[i];
                    } else
                        return new int[0];
                }
                m.put(rains[i], i);
            }
        }
        return ans;
    }
}
