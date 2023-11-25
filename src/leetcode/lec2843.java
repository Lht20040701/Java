package leetcode;

public class lec2843 {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(100, 1782));
    }
    public static int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for (int i = low; i <= high; i ++ ) {
            if (f(i)) cnt ++ ;
        }
        return cnt;
    }

    public static boolean f(int x) {
        int w = (int) Math.log10(x) + 1;
        if (w <= 1) return false;
        if (w % 2 == 1) return false;

        int div = (int) Math.pow(10, w / 2);
        int ri = x % div;
        int le = x / div;
//        if (w % 2 == 1) le = x / (div * 10);

//        if (getSumX(le) == getSumX(ri)) System.out.println(x);
        return getSumX(le) == getSumX(ri);
    }

    public static int getSumX(int x) {
        int ret = 0;
        while (x > 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}
