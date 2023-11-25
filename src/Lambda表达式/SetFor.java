package Lambda表达式;

import java.util.HashSet;
import java.util.Set;

public class SetFor {
    public static void main(String[] args) {
        Set<String> st = new HashSet<>();

        st.add("李菜菜");
        System.out.println(st.add("李菜菜"));

        st.add("大脸妹");
        st.add("阿衰");
        st.add("哆啦A梦");

        System.out.println(st);
        for (String s: st) System.out.print(s + " ");
        System.out.println("");
        st.forEach(s -> System.out.print(s + " "));

        /**
         * false
         * [阿衰, 大脸妹, 李菜菜, 哆啦A梦]
         * 阿衰 大脸妹 李菜菜 哆啦A梦
         * 阿衰 大脸妹 李菜菜 哆啦A梦
         * */
    }
}