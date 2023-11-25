package leetcode;
import java.util.Arrays;

// 题解 : https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/solutions/2500330/heng-qie-he-shu-qie-shi-hu-xiang-du-li-d-gywp/?envType=daily-question&envId=2023-10-27
public class lec1465N {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int Mh = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int Mw = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        int n = horizontalCuts.length, m = verticalCuts.length;
        for (int i = 1; i < n; i ++ ) Mh = Math.max(Mh, horizontalCuts[i] - horizontalCuts[i - 1]);
        for (int i = 1; i < m; i ++ ) Mw = Math.max(Mw, verticalCuts[i] - verticalCuts[i - 1]);

        return (int) ((long) Mh * Mw % 1000000007);
    }
}