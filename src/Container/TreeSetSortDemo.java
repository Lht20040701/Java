package Container;

import java.util.TreeSet;

public class TreeSetSortDemo {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>((o1, o2) -> {
            int x = o1.length() - o2.length();
            x = x == 0 ? o1.compareTo(o2) : x;
            return x;
        });
        // 先按照长度大小排序, 然后按照AscII表排

        ts.add("Licaicai");
        ts.add("Ashuai");
        ts.add("Dalianmei");
        ts.add("Nobida");

        System.out.println(ts);
//        [Ashuai, Nobida, Licaicai, Dalianmei]
    }
}
