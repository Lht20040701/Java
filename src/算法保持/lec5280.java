package 算法保持;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lec5280 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        String s = sc.next(), t = sc.next();

        int tag = 0x3f3f3f3f;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= t.length() - s.length(); i ++ ) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < s.length(); j ++ ) {
                if (s.charAt(j) != t.charAt(i + j)) path.add(j + 1);
            }

            if (tag > path.size()) {
                ans = path;
                tag = path.size();
            }
        }
        System.out.println(ans.size());
//        System.out.println(ans);
        if (ans.size() != 0) {
            for (int x : ans) System.out.print(x + " ");
        }
    }
}
