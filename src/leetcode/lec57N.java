package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec57N {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lis = new ArrayList<>();

        int st = newInterval[0];
        int ed = newInterval[1];

        boolean f = false; // 没有放入答案

        for (int[] interval: intervals) {
            if (interval[0] > ed) {
                if (!f) { // 都超过他而且没有交集还还没放过答案, 说明可以直接放进去
                    lis.add(new int[]{st, ed});
                    f = true;
                }
                lis.add(interval);
            }
            else if (interval[1] < st) lis.add(interval);
            else { // 有交集了, 求出交集, 更新区间, 求两个区间的并集是固定套路, 直接写就好了
                st = Math.min(st, interval[0]);
                ed = Math.max(ed, interval[1]);
            }
        }

        if (!f) lis.add(new int[]{st, ed}); // 如果最后了还没放答案, 直接放进去就好了

        return lis.toArray(new int[0][0]);
    }
}
