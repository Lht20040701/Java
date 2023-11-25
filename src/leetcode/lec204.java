package leetcode;

public class lec204 {
    static final int N = 10000100;

    int[] primes = new int[N];
    boolean[] st = new boolean[N];
    int cnt;

    public int countPrimes(int n) {
        for (int i = 2; i < n; i ++ ) {
            if (!st[i]) primes[cnt ++ ] = i;
            for (int j = 0; primes[j] <= n / i; j ++ ) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
        return cnt;
    }
}