package 方法引用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Demo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "aaa", "bbb", "ccc", "ddd", "eee");

        list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(s -> System.out.println(s));

        System.out.println("----------------------------------");

        list.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));

        /**
         * 这里的引用引用了String类中的无参方法toUpperCase()
         *          我们按照通过类型引用成员方法的规则来讲一下就明白了 :
         *              首先就是抽象方法apply中的第一个参数是String s, 代表着我们可以引用String里的方法
         *              然后该抽象方法没有第二个参数, 说明我们可以引用String里面的无参成员方法
         *              此时我们的toUpperCase在符合规则的条件下又可以满足我们的需求, 于是我们可以引用
         * */
    }
}
