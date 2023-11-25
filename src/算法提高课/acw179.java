package 算法提高课;

import java.util.*;

public class acw179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder start = new StringBuilder(), seq = new StringBuilder();
        while (sc.hasNext()) {
            String x = sc.next();
            start.append(x);
            if (!"x".equals(x)) seq.append(x);
        }

//        System.out.println(start);

        int t = 0;
        for (int i = 0; i < seq.length(); i ++ )
            for (int j = i + 1; j < seq.length(); j ++ )
                if (seq.charAt(i) > seq.charAt(j)) t ++ ;

        if (t % 2 == 1) System.out.println("unsolvable");
        else System.out.println(Astar(start.toString()));
    }

    static class PCS {
        char op;
        String state;
        public PCS(char op, String state) {
            this.op = op;
            this.state = state;
        }
    }

    static class PIS {
        int cnt;
        String state;
        public PIS(int cnt, String state) {
            this.cnt = cnt;
            this.state = state;
        }
    }

    public static int f(String state) {
        int res = 0;
        for (int i = 0; i < state.length(); i ++ )
            if (state.charAt(i) != 'x') {
                int t = state.charAt(i) - '1';
                res += Math.abs(i / 3 - t / 3) + Math.abs(i % 3 - t % 3);
            }

        return res;
    }

    public static String Astar(String start) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        char[] op = {'u', 'r', 'd', 'l'};

        String end = "12345678x";
        Map<String, Integer> dist = new HashMap<>();
        Map<String, PCS> prev = new HashMap<>();
        PriorityQueue<PIS> heap = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);

        heap.add(new PIS(f(start), start));
        dist.put(start, 0);

        while (!heap.isEmpty()) {
            PIS t = heap.poll();
            StringBuilder state = new StringBuilder(t.state);

            if (state.toString().equals(end)) break;

            int step = dist.getOrDefault(state.toString(), 0x3f3f3f3f);

            int x = 0, y = 0;
            for (int i = 0; i < state.length(); i ++ )
                if (state.charAt(i) == 'x') {
                    x = i / 3; y = i % 3;
                    break;
                }

            String source = state.toString();
            for (int i = 0; i < 4; i ++ ) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    swap(state, x * 3 + y, a * 3 + b);
                    if (!dist.containsKey(state.toString()) || dist.get(state.toString()) > step + 1) {
                        dist.put(state.toString(), step + 1);
                        prev.put(state.toString(), new PCS(op[i], source));
                        heap.add(new PIS(dist.get(state.toString()) + f(state.toString()), state.toString()));
                    }
                    swap(state, x * 3 + y, a * 3 + b);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!end.equals(start)) {
            if (prev.containsKey(end)) {
                res.append(prev.get(end).op);
                end = prev.get(end).state;
            }
        }

        res.reverse();
        return res.toString();
    }

    public static void swap(StringBuilder s, int i, int j) {
        char t = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, t);
    }
}
