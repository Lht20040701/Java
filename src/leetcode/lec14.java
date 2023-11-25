package leetcode;

public class lec14 {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();

        int now = 0;

        int mi = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i ++ ) mi = Math.min(mi, strs[i].length());

        for (int i = 0; i < mi; i ++ ) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++ ) {
                if (strs[j].charAt(i) == c) continue;
                return s.toString();
            }
            s.append(c);
        }

        return s.toString();
    }
}
