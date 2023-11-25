package 新生赛;

        import java.util.Scanner;

public class calcDay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int cnt = 0;
        for (int i = n + 1; i <= m; i ++ ) {
            if (judge(i)) cnt ++ ;
        }
        System.out.println(cnt);
    }

    public static boolean judge (int now) {
        int y = now / 10000;
        int m = now / 100 % 100;
        int d = now % 100;

        if (m < 1 || m > 12) return false;
        if (d > 31 || d < 1) return false;
        if ((m == 4 || m == 6 || m == 9 || m == 11) && d == 31) return false;

        if (m == 2 && d > 29) return false;
        boolean f = RP(y);
        if (!f && m == 2 && d == 29) return false;
        return true;
    }

    public static boolean RP(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 != 0 && y % 4 == 0) return true;
        return false;
    }
}
