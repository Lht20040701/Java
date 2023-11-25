package leetcode;

public class lec42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
    public static int trap(int[] height) {
        int mh = 0, h = 0;
        for (int k = 0; k < height.length; k ++)
            if (mh < height[k]) {
                mh = height[k];
                h = k;
            }

//        System.out.println(h);

        int i = 0;
        while (height[i] == 0 && i < h) i ++ ;
        int j = i + 1;
        int ans = 0;
        for (; j < h; j ++ ) {
            if (height[j] < height[i]) ans += height[i] - height[j];
            else i = j;
        }

        i = height.length - 1;
        while (height[i] == 0 && i > h) i -- ;
        j = i - 1;
        for (; j > h; j -- ) {
            if (height[j] < height[i]) ans += height[i] - height[j];
            else i = j;
        }

        return ans;
    }
}
