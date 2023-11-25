package newCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NC252724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            int n = sc.nextInt();
            int now = 1;
            List<Integer> lis = new ArrayList<>();
            while (n > 0) {
                if (n <= 2 * now) {
                    lis.add(n);
                    break;
                } else {
                    lis.add(now);
                    n -= now;
                    now ++ ;
                }
            }
            int m = lis.size();
            for (int i = 0; i < m; i ++ ) System.out.print(lis.get(i) + " ");
            System.out.println();
        }
    }
}
