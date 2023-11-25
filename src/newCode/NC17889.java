package newCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class NC17889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> st = new HashSet<>();

        int n = sc.nextInt();
        int x = 1;
        while (n -- > 0) {
            String op = sc.next();
            if ("New".equals(op)) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.peek());
                    st.add(pq.poll());
                    continue;
                }
                System.out.println(x);
                st.add(x);
                x ++ ;
            } else {
                int t = sc.nextInt();
                if (st.contains(t)) {
                    System.out.println("Successful");
                    st.remove(t);
                    pq.add(t);
                }
                else System.out.println("Failed");
            }
        }
    }
}
