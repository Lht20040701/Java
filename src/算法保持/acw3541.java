package 算法保持;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class PII {
    int x, y;
}

public class acw3541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PII[] pi = new PII[n];

        for (int i = 0; i < n; i ++ ) {
            pi[i] = new PII();
        }

        for (int i = 0; i < n; i ++ ) {
            pi[i].x = sc.nextInt();
            pi[i].y = sc.nextInt();
        }

        Arrays.sort(pi, new Comparator<PII>() {
            @Override
            public int compare(PII o1, PII o2) {
                if (o1.x != o2.x) return o1.x - o2.x;
                return o1.y - o2.y;
            }
        });

        System.out.println(pi[0].x + " " + pi[0].y);
    }
}
