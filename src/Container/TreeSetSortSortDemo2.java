package Container;

import java.util.TreeSet;

public class TreeSetSortSortDemo2 {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        ts.add(new Student(19, "李菜菜"));
        ts.add(new Student(18, "哆啦A梦"));
        ts.add(new Student(17, "蜡笔小新"));
        System.out.println(ts);

//        [Student{age=17, name='蜡笔小新'}, Student{age=18, name='哆啦A梦'}, Student{age=19, name='李菜菜'}]
    }
}

class Student implements Comparable<Student> {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return this.age -  o.age; // 按年龄升序
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
