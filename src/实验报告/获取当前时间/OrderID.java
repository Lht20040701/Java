package 实验报告.获取当前时间;

import java.time.LocalDateTime;
import java.util.Random;

public class OrderID {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++ ) System.out.println(getNowOrderID());
    }

    public static String getNowOrderID() {
        LocalDateTime now = LocalDateTime.now();
        String[] s = now.toString().split("[-T:.]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i ++ ) sb.append(s[i]);
        Random r = new Random();
        int x = r.nextInt(Integer.MAX_VALUE);
        StringBuilder X = new StringBuilder(String.valueOf(x));
        int w = (int) Math.log10(x) + 1, W = (int) Math.log10(Integer.MAX_VALUE) + 1;
//        sb.append(" ");
        while (w <= W) {
            X.insert(0, 0);
            w ++ ;
        }
        sb.append(X);
        return sb.toString();
    }
}