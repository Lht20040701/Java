package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//public class lec151 {
//    public static void main(String[] args) {
//        System.out.println(reverseWords("  hello world  "));
//    }
//    public static String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        List<String> sarr = new ArrayList<>(Arrays.asList(s.split("[ ]+")));
//        if (sarr.size() != 0 && sarr.get(0).equals("")) sarr.remove(0);
//
//        for (int i = sarr.size() - 1; i >= 0; i -- ) {
//            sb.append(sarr.get(i));
//            if (i != 0) sb.append(" ");
//        }
//
//        return sb.toString();
//    }
//}

public class lec151 {
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> lis = Arrays.asList(s.split("[ ]+"));
        Collections.reverse(lis);
        return String.join(" ", lis);
    }
}
