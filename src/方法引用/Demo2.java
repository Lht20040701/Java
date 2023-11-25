package 方法引用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "张三", "李四", "张无忌", "张三风", "李菜菜", "哆啦A梦");

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

        System.out.println("----------------------------------------------------");

        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length() == 3;
            }
        }).forEach(s -> System.out.println(s));

        System.out.println("----------------------------------------------------");

        // 通过引用其他类中的成员方法, 对象::方法名
        list.stream().filter(new StringOperation()::stAndLen).forEach(s -> System.out.println(s));

        // 此处用不了this::方法名, 因为我们这里是静态成员方法main里, 静态方法中是没有this关键字的, 所以还是通过创建对象来引用的
        list.stream().filter(new Demo2()::stAndLen).forEach(s -> System.out.println(s));
    }

    public boolean stAndLen(String s) {
        return s.startsWith("张") && s.length() == 3;
    }
}

class StringOperation {
    public boolean stAndLen(String s) {
        return s.startsWith("张") && s.length() == 3;
    }
}
