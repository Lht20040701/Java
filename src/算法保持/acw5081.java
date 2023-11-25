package 算法保持;

import java.util.HashMap;
import java.util.Scanner;

public class acw5081 {
    static int n;

    public static void main(String[] args) {

        HashMap<String, Integer> ha = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i ++ ) {
            StringBuilder s = new StringBuilder();
            for (int j = 1; j <= 8; j ++ ) {
                String x = sc.nextLine();
//                System.out.println(x + ' ' + j);
                s.append(x);
            }

//            System.out.println(s.toString());

            if (ha.get(s.toString()) == null) ha.put(s.toString(), 1);
            else ha.put(s.toString(), ha.get(s.toString()) + 1 );
            System.out.println(ha.get(s.toString()));
        }
    }
}
