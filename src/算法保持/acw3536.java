package 算法保持;

import java.util.Arrays;
import java.util.Scanner;

public class acw3536 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String m = sc.next();
        String y = sc.next();

        int[] mt = new int[m.length()];
        int[] yt = new int[y.length()];

        int[] cnt = new int[11];

        for (int i = 0; i < m.length(); i ++ ) {
            mt[i] = m.charAt(i) - '0';
            cnt[mt[i]] ++ ;
        }
        for (int i = 0; i < y.length(); i ++ ) yt[i] = y.charAt(i) - '0';

        Arrays.sort(mt); Arrays.sort(yt);

        StringBuilder sbm = new StringBuilder();
        StringBuilder sby = new StringBuilder();

        for (int i = 0; i < mt.length; i ++ ) sbm.append("").append(mt[i]);
        for (int i = 0; i < yt.length; i ++ ) sby.append("").append(yt[i]);

        m = sbm.toString();
        y = sby.toString();

        boolean f =  false;

        int op = y.length();

//        for (int i = 0; i < cnt.length; i ++ ) {
//            System.out.println(i + " " + cnt[i]);
//        }

        for (int i = 0; i <= m.length() - y.length(); i ++ ) {
            String t = m.substring(i, i + y.length());
            boolean re = true;

            if (op < 5) {
                char ju = t.charAt(0);
                for (int j = 1; j < t.length(); j ++ ) {
                    if (t.charAt(j) != ju) {
                        re = false;
                        break;
                    }
                }
                if (re && t.charAt(0) - '0' > y.charAt(0) - '0') {
                    f = true;
                    break;
                }
            } else {
                char ju = y.charAt(0);
                for (int j = ju - '0' + 1; j < ju - '0' + 1 + 5; j ++ ) {
//                    System.out.print(j + "");
                    if (cnt[j] == 0) {
                        re = false;
                        break;
                    }
                }
                if (re) f = true;
//                System.out.println("");
            }

        }

        if (f) System.out.println("YES");
        else System.out.println("NO");
    }

}
