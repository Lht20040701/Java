package 算法保持;

import java.util.Scanner;

public class acw786 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i ++ ) nums[i] = sc.nextInt();
        System.out.println(qs(nums,0, n - 1, k)); // 快速选择
    }

    public static int qs(int[] nums, int l, int r, int k) {
        if (l >= r) return nums[l]; // 递归结束条件
        int i = l - 1, j = r + 1;
        int x = nums[l + r >> 1];
        while (i < j) {
            while (nums[ ++ i] < x) ;
            while (nums[ -- j] > x) ;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        int sl = j - l + 1; // 最后i == j, 是j左边的全是 <= x的, 右边的全是 >= x的
        if (k <= sl) return qs(nums, l, j, k); // 在左边, 去左边找
        return qs(nums, j + 1, r, k - sl); // 在右边, 去右边找
    }
}
