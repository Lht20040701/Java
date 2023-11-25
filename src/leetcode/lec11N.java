package leetcode;

public class lec11N {
    public static void main(String[] args) {

    }

    /**
     * 无论长板或短板谁往中间收一格, 都会导致底边减1
     * 如果移动短板, 可能导致min(长板, 短板)变大, 导致面积变大
     * 如果移动长板, 一定会导致min(长板, 短板)不变或者减少, 导致下个面积减少
     *
     * 所以双指针枚举板子和更新面积, 从两边往中间靠, 碰到了退出来就好
     * */

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            boolean f = false; // 左高
            if (height[i] < height[j]) f = true; // 右高
            int mih = Math.min(height[i], height[j]);
            max = Math.max(max, (j - i) * mih);

            if (f) i ++ ;
            else j -- ;
        }

        return max;
    }
}
