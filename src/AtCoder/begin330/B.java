package AtCoder.begin330;

import java.util.Scanner;
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
        int[] arr = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) arr[i] = sc.nextInt();
        for (int i = 1; i <= n; i ++ ) {
            if (arr[i] >= l && arr[i] <= r) {
                System.out.print(arr[i] + " ");
                continue;
            }
            int dl = Math.abs(arr[i] - l);
            int dr = Math.abs(arr[i] - r);

            if (dl <= dr) System.out.print(l + " ");
            else System.out.print(r + " ");
        }
    }
}