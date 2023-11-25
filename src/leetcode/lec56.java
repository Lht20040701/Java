package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class lec56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int ed = -1000;

        ArrayList<int[]> list = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < intervals.length; i ++ ) {
            if (intervals[i][0] > ed) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                cnt ++ ;
                ed = intervals[i][1];
            }
            ed = Math.max(ed, intervals[i][1]);
            list.get(cnt - 1)[1] = ed;
        }

        return list.toArray(new int[list.size()][2]);
    }
}
