package Container;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(5);
        ts.add(2);
        ts.add(8);
        ts.add(1);
        ts.add(3);
        ts.add(0);

        System.out.println(ts);
        for (Integer t : ts) System.out.print(t);
        System.out.println("");
        ts.forEach(i -> System.out.print(i));
    }
}
