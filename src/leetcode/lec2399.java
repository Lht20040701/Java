package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lec2399 {
    HashMap<Character, Integer> ha = new HashMap<>();

    public boolean checkDistances(String s, int[] distance) {
        ArrayList<Integer> lis = new ArrayList<>();
        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < 26; i ++ ) lis.add(0);

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i ++ ) {
            st.add(ch[i] - 'a');
            if (ha.containsKey(ch[i])) lis.set(ch[i] - 'a', i - ha.get(ch[i]) - 1);
            else ha.put(ch[i], i);
        }

        for (int i = 0; i < 26; i ++ ) {
            if (!st.contains(i)) continue;

            if (lis.get(i) != distance[i]) return false;
        }
        return true;
    }
}
