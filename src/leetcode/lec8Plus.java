package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec8Plus {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton(); // 创建自动机对象
        int len = s.length();
        for (int i = 0; i < len; i ++ )
            automaton.get(s.charAt(i)); // 使用自动机处理数据
        return (int) (automaton.sign * automaton.ans); // 返回结果
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{ // 双括号初始化法
        // 初始化状态转移表
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)]; // 自动机状态的转移
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE); // 注意这里一定要把负号写外面
        } else if ("signed".equals(state)) sign = c == '+' ? 1 : -1; // 改变符号
    }

    private int get_col(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (Character.isDigit(c)) return 2;
        return 3;
    }
}