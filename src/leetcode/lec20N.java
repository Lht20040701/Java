package leetcode;

import java.util.Stack;

public class lec20N {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<>();

        for (int i = 0; i < s.length(); i ++ ) {
            char x = s.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                sta.push(s.charAt(i));
            } else if (!sta.empty()) {
                char _x = sta.pop();
                char x_ = '(';
                if (x == ']') x_ = '[';
                if (x == '}') x_ = '{';
                if (_x != x_) return false;
            } else return false;
        }
        return sta.empty();
    }
}
