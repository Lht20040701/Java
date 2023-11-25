package leetcode;

import java.util.*;

public class lec2512 {
    public static void main(String[] args) {

    }

    public void init(HashMap<String, Integer> ha, String[] positive_feedback, String[] negative_feedback) {
        for (String x : positive_feedback) ha.put(x, 3);
        for (String x : negative_feedback) ha.put(x, -1);
    }

    class Student {
        Integer score;
        Integer id;

        public Student(Integer score, Integer id) {
            this.score = score;
            this.id = id;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashMap<String, Integer> ha = new HashMap<>();
        init(ha, positive_feedback, negative_feedback);
        Student[] s = new Student[student_id.length];

        for (int i = 0; i < s.length; i ++ ) {
            int sc = 0;
            String[] tem = report[i].split(" ");

            for (String x : tem) {
//                System.out.println(x);
                if (ha.containsKey(x)) sc += ha.get(x);
            }

            s[i] = new Student(sc, student_id[i]);
        }

//        for (var x : s) {
//            System.out.println(x.score + " " + x.id);
//        }

        Arrays.sort(s, (o1, o2) -> {
                if (o1.score != o2.score) return o2.score - o1.score;
                return o1.id - o2.id;
            }
        );

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i ++ ) ans.add(s[i].id);

        return ans;
    }
}
