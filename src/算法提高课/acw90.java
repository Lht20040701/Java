package 算法提高课;

import java.math.BigInteger;
import java.util.Scanner;

public class acw90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger ba = new BigInteger(sc.next());
        BigInteger bb = new BigInteger(sc.next());
        BigInteger bp = new BigInteger(sc.next());

        System.out.println(ba.multiply(bb).mod(bp));
    }
}

class acw90_Solution2 {
    /**
     * 思路 : 我们之前学过快读幂, 现在我们有龟速乘, 因为我们把原本是O(1)的乘法写成了最终时间复杂度是O(log b)的写法
     *
     *       a * b % p -> a, b, p最终都在1e18以内
     *       类似与快读幂, 我们把b根据二进制拆开
     *          比如 : b = 11010 (二进制)
     *          那么b就可以写成   : b = 2^1 + 2^3 + 2^4
     *          那么a * b可以写成 : b = a * 2^1 + a * 2^3 + a * 2^4
     *
     *          所以这么拆开以后, 我们最多只需要算log b次就行
     *          计算过程中每次我们都有 :
     *          a mod p
     *          2a mod p
     *          4a mod p
     *          8a mod p
     *          ..    ..
     *
     *          计算这次的时候只需要 上一次的结果 * 2 mod p就好了
     *          而p是在1e18以内, 所以不会爆long
     * */

    private static long gadd(long a, long b, long p) {
        long res = 0;
        while (b != 0) {
            if ((b & 1) == 1) res = (res + a) % p;
            b >>=1;
            a = (a + a) % p;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong(), b = sc.nextLong(), p = sc.nextLong();
        System.out.println(gadd(a, b, p));
    }
}
