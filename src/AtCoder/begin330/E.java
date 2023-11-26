package AtCoder.begin330;

import java.util.*;

class Main5 {
    /**
     * 总结 : mex的取值范围跟数据长度有关, 而跟元素取值范围无关
     *
     * 思路 : 首先我们只需要用TreeSet维护0 -> N就好了, 我们答案一定在0 -> N中
     *       因为 mex (...arr) -> 数组arr中没出现过的最小非负整数, 数组长度是N, 那么我们mex得到数一定在0 -> N之间, 最大也就是0 -> N - 1在数组中全都出现了, 那mex取的就是N
     *       所以别看Ai给的数据范围是1e9, 但是我们遇到大于等于N的数就可以不用管了, 用哈希表维护0 -> N - 1每个数出现的次数, 看每一个询问是否需要添加删除元素 (当然需要添加和删除元素的取值范围也是0 -> N - 1)
     *
     *
     *       然后就是为什么使用TreeSet而不用PriorityQueue, 这个是 红黑树和最小堆 性能优劣的问题
     *       先放结论 : 如果 插入+查找最小+删除最小 总体来确定红黑树和最小堆，红黑树占优，性能波动相对较小，红黑树不过多的依赖比较，相对最小堆由比较带来的的性能影响较小（如果比较是调用自定义函数、比较的是字符串等，那么性能就牺牲很大）
     *       然后就是详细解答 : https://blog.csdn.net/abcd1f2/article/details/45333715#:~:text=%E5%A6%82%E6%9E%9C%E6%8F%92%E5%85%A5%2B%E6%9F%A5%E6%89%BE%E6%9C%80,%E6%80%A7%E8%83%BD%E5%B0%B1%E7%89%BA%E7%89%B2%E5%BE%88%E5%A4%A7%EF%BC%89
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), q = sc.nextInt();
        TreeSet<Integer> st = new TreeSet<>();
        int[] hx = new int[n];
        int[] arr = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) arr[i] = sc.nextInt();
        for (int i = 1; i <= n; i ++ )
            if (arr[i] < n) hx[arr[i]] ++ ;

        for (int i = 0; i <= n; i ++ ) st.add(i);

        for (int i = 1; i <= n; i ++ ) {
            if (arr[i] < n) st.remove(arr[i]);
        }

        for (int i = 1; i <= q; i ++ ) {
            int ik = sc.nextInt(), x = sc.nextInt();
            int re = arr[ik]; arr[ik] = x;

            if (re < n && hx[re] == 1) st.add(re);
            if (re < n) hx[re] -- ;

            if(x < n && hx[x] == 0) st.remove(x);
            if (x < n) hx[x] ++ ;

            System.out.println(st.first());
        }
    }
}
