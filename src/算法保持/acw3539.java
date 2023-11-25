package 算法保持;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Fu {
    int x, y;
}

public class acw3539 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        PriorityQueue<Fu> heap = new PriorityQueue<>(new Comparator<Fu>() {
            @Override
            public int compare(Fu o1, Fu o2) {
                if (o2.x * o2.x + o2.y * o2.y != o1.x * o1.x + o1.y * o1.y) {
                    return o2.x * o2.x + o2.y * o2.y - (o1.x * o1.x + o1.y * o1.y); // 升序
                } else {
                    return o1.y - o2.y;
                }
            }
        });

        for (int i = 0; i < n; i ++ ) {
            String op = sc.next();
            if (op.equals("Pop")) {
                if (heap.size() == 0) System.out.println("empty");
                else {
                    Fu f = heap.poll();
                    System.out.println(f.x + "+i" + f.y);
                    System.out.println("SIZE = " + heap.size());
                }
            } else {
                String s = sc.next();
                Fu f = new Fu();
                f.x = Integer.parseInt(s.substring(0, s.indexOf('+')));
                f.y = Integer.parseInt(s.substring(s.indexOf('i') + 1));

                heap.add(f);
                System.out.println("SIZE = " + heap.size());
            }
        }
    }
}
