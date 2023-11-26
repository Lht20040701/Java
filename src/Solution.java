import java.util.PriorityQueue;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long st = System.currentTimeMillis();
        for (int i = 10000000; i >= 0; i -- ) pq.add(i);
        long ed = System.currentTimeMillis();

        System.out.println("pq -> add : " + (ed - st));


        st = System.currentTimeMillis();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 10000000; i >= 0; i -- ) ts.add(i);
        ed = System.currentTimeMillis();

        System.out.println("ts -> add : " + (ed - st));


        st = System.currentTimeMillis();
        for (int i = 0; i <= 10000000; i ++ ) pq.remove(i);
        ed = System.currentTimeMillis();

        System.out.println("pq -> remove : " + (ed - st));


        st = System.currentTimeMillis();
        for (int i = 0; i <= 10000000; i ++ ) ts.remove(i);
        ed = System.currentTimeMillis();

        System.out.println("ts -> remove : " + (ed - st));
    }
}