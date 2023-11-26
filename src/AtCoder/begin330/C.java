package AtCoder.begin330;

import java.util.Scanner;
class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long d = sc.nextLong();

        long ans= 99999999999999L;
        for (int i = 0; i <= 2000100; i ++ ) {
            long j = (long)Math.sqrt(d - (long) i * i);
            ans = Math.min(ans, Math.min(Math.abs((long) i * i + (j * j) - d), Math.abs((j + 1) * (j + 1) + (long) i * i - d)));
        }

        System.out.println(ans);
    }
}
