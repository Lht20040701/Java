package 方法引用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "李菜菜-19", "大脸妹-15", "阿衰-15", "野比大雄-13", "哆啦A梦-19");

        // 最开始的匿名内部类写法
        List<Student> newList = list.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                return new Student(s.split("-")[0], Integer.parseInt(s.split("-")[1]));
            }
        }).collect(Collectors.toList());

        // lambda表达式写法
        List<Student> newList2 = list.stream()
                .map(s -> new Student(s.split("-")[0], Integer.parseInt(s.split("-")[1])))
                .collect(Collectors.toList());

        // 给Student添加了指定的构造方法以后直接引用
        List<Student> newList3 = list.stream()
                .map(Student::new)
                .collect(Collectors.toList());

    }
}
