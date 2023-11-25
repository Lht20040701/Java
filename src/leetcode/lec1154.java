package leetcode;

public class lec1154 {
    public int dayOfYear(String date) {
        String[] sp = date.split("-");
        int sum = 0;
        int y = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int d = Integer.parseInt(sp[2]);

        boolean f = y % 400 == 0 || (y % 100 != 0 && y % 4 == 0);

        for (int i = 1; i < m; i ++ ) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) sum += 31;
            else if (i == 2) {
                sum += 28;
                if (f) sum ++ ;
            } else sum += 30;
        }

        sum += d;
        return sum;
    }
}
