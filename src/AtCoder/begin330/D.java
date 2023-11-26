package AtCoder.begin330;

import java.util.Scanner;

//import java.util.Scanner;
class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] ss = new String[n + 10];
        for (int i = 1; i <= n; i ++ ) ss[i] = sc.next();

        int[] row = new int[ss[1].length() + 10];
        int[] col = new int[n + 10];

        for (int i = 1; i <= n; i ++ )
            for (int j = 0; j < ss[1].length(); j ++ )
                if (ss[i].charAt(j) == 'o') row[i] ++ ;

        for (int i = 0; i < ss[1].length(); i ++ )
            for (int j = 1; j <= n; j ++ )
                if (ss[j].charAt(i) == 'o') col[i] ++ ;

        long ans = 0;
        for (int i = 1; i <= n; i ++ )
            for (int j = 0; j < ss[1].length(); j++) {
                if (ss[i].charAt(j) == 'x') continue;
                ans += (long) (row[i] - 1) * (long) (col[j] - 1);
            }

        System.out.println(ans);
    }
}