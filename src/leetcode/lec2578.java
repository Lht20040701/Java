package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class lec2578 {
    public int splitNum(int num) {
        ArrayList<Integer> lis = new ArrayList<>();

        int lg = (int) Math.log10(num) + 1;

        for (int i = 1; i <= lg; i ++ ) {
            lis.add(num % 10);
            num /= 10;
        }

        Collections.sort(lis);

        int a = 0, b = 0;

        for (int i = 0; i < lis.size(); i ++ ) {
            if (i % 2 == 0) a = a * 10 + lis.get(i);
            else b = b * 10 + lis.get(i);
        }

        return a + b;
    }
}
