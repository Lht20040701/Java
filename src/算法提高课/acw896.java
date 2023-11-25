package 算法提高课;

import java.util.Scanner;

public class acw896 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 10];

        for (int i = 0; i < n; i ++ ) a[i] = sc.nextInt();
        int[] q = new int[n + 10]; // q[len]存的是所有长度为len的子序列中最末尾值最小的那个子序列
        // 可以证明随着len的增大, q[len]一定是严格单调递增的

        int len = 0; // 最大长度为0
        q[0] = -2_000_000_010; // 放置一个哨兵而已, 因为我们的初始值不能为零, 数据范围给的a[i] >= -1e9
        for (int i = 0; i < n; i ++ ) { // 遍历
            int l = 0, r = len;
            while (l < r) { // 二分出当前的q数组中小于a[i]的最大的那个数, 即 : 目前所有最后一位小于a[i]的子序列中, 长度最长(且末尾值最小, 这个条件q数组已经保证了)的那一个
                int mid = l + r + 1 >> 1;
                if (q[mid] < a[i]) l = mid;
                else r = mid - 1;
            }
            len = Math.max(len, r + 1); // r == len的时候才会更新我们的答案, 说明存在目前搜索到的长度最长的子序列的最后一位比我小, 更新len为len + 1
            q[r + 1] = a[i];
            // 这一步必定更新, 如果r < len的情况, 我们知道q[r] < a[i], 那么根据q数组的性质(随着len的增加单调递增), q[r + 1]一定>=a[i], 所以我们要更新答案
            // 如果r == len的话那就是找到了长度更长的上升子序列, 我们也要更新q[r + 1]为当前a[i]
        }

        System.out.println(len); // 输出答案, 也就是最大的len
    }
}
