package 算法保持;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class acw1230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong(), k = sc.nextLong();
        long[] arr = new long[(int) n];

        for (int i = 0; i < n; i ++ ) arr[i] = sc.nextLong();

//        (s[i] - s[j - 1]) % k == 0 ---> (s[i] % k - s[j - 1] % k) % k == 0 ---> s[i] % k == s[j - 1] % k

        long sum = 0, ans = 0;
        Map<Long, Long> ma = new HashMap<>();
        ma.put(0L, 1L);
        for (int i = 0; i < n; i ++ ) {
            sum += arr[i];
            long x = sum % k;
            ans += ma.getOrDefault(x, 0L);
            ma.put(x, ma.getOrDefault(x, 0L) + 1);
        }

        System.out.println(ans);
    }
}
