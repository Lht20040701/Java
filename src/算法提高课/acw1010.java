package 算法提高课;

import java.util.Scanner;

public class acw1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[1010];
        int n = 0;
        while (sc.hasNext()) a[ ++ n] = sc.nextInt();
        int len = 0;
        int[] p = new int[n + 10];
        p[0] = 0x3f3f3f3f; // 找的是最长不上升子序列, 所以根据p数组的含义, 这里的哨兵应该是正无穷 (想不明白就自己画图, 之前模板是p严格单调上升, 这里是p不严格单调下降

        for (int i = 1; i <= n; i ++ ) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (p[mid] >= a[i]) l = mid; // 找的是最后一个个大于等于a[i]的
                else r = mid - 1;
            }

            len = Math.max(len, r + 1);
            p[r + 1] = a[i]; // 更新
        }

        System.out.println(len);

        /**
         * q[i]的含义 : 第i个不上升队列的末尾的值
         * 贪心策略 :
         *      1. 遍历a[i], 从所有末端大于等于a[i]的末端中选一个末端值最小的队列, 然后把a[i]放进去
         *      2. 如果没找到末端大于等于a[i]的队列, 那就新开一个队列然后把a[i]放进去
         *
         *      经过上述贪心以后不难发现, q[i]的值只会越更新越小, 所以q的值是严格单调递增的, 所以我们找的时候可以采用二分来找到第一个大于等于a[i]的值, 也就是右边界
         * */

        int[] q = new int[n + 10]; //
        q[0] = -1; // 第0个队列设为哨兵, 不用
        int idx = 0; // 当前队列的个数
        for (int i = 1; i <= n; i ++ ) { // 遍历每一个点
            int l = 0, r = idx;
            while (l < r) {
                int mid = l + r >> 1;
                if (q[mid] >= a[i]) r = mid;
                else l = mid + 1;
            }

            if (q[l] < a[i]) q[ ++ idx] = a[i];
            else q[l] = a[i];
        }

        System.out.println(idx);
    }
}
