package leetcode;

public class lec2652N {
    /**
     * 容斥原理 :
     *      考虑到[1, n]内能被数m整除的整数, 从小到大排序后成为一个等差数列, 利用等差数列求和公式是
     *          f(n, m) = (m + (n / m) * m) * (n / m) / 2; 注意n / m是下取整(可以看看lec官方的题解, 公式写的还是比较美的)
     *      然后根据容斥原理得到结果 :
     *          f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
     * */
    public int f(int n, int m) {
        return (m + m * (n / m)) * (n / m) / 2;
    }

    public int sumOfMultiples(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }
}
