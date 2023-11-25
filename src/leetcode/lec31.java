package leetcode;

import java.util.Arrays;

public class lec31 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};

        do {
            System.out.println(Arrays.toString(a));
        } while (nextPermutation(a, 0, 4));
    }
//    SolveLink : https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/?envType=study-plan-v2&envId=top-100-liked
    public static boolean nextPermutation(int[] nums, int l, int r) { // 对[l, r)进行全排列
        if (nums.length <= 1) return false;

        // 关于这三步的操作得出的下一个排列为什么保证增加幅度最小, 请看上述题解链接
        // 第一步：从尾部到前部，找到第一个升序的俩个值，i-1和i，那i-1就是我们要置换的位置，在12354里我们找到3这个值
        // 跟谁换？跟右边倒数第一个大于它的值换（第二步）
        int pos = -1, n = r;
        for (int i = n - 1; i >= 1; i -- ) { // 找出第一个相邻的升序对
            if (nums[i - 1] < nums[i]) {
                pos = i - 1; // 将pos更新为该逆序对较小的那个
                break;
            }
        }

        //没有更大的排列了
        if (pos == -1) {
            return false;
        }

        //第二步：从尾部到前部找到第一个大于 nums[pos]的值 交换，12354里交换3和4变成 12453
        for (int i = n - 1; i >= 0; i -- ) {
            if (nums[pos] < nums[i]) {
                swap(nums, pos, i);
                break;
            }
        }
        //第三步：给 [pos+1,length) 到转一下，12453变成12435
        reverse(nums, pos + 1, n);
        return true;
    }

    public static void reverse(int[] arr, int l, int r) { // 逆转[l, r)
        for (int i = l, j = r - 1; i < j; i ++ , j -- ) swap(arr, i, j);
    }

    public static void swap(int[] arr, int i, int j) { // 交换[i], [j]
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}
