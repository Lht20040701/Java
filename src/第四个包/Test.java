package 第四个包;

import 第四个包.demo1.Teacher;
//import 第四个包.demo2.Teacher;

public class Test {
    public static void main(String[] args) {

        // 第一种情况 同一个包中的类
        Student s = new Student();
        s.setName("张三");
        s.setAge(23);

        System.out.println(s.getName() + ", " + s.getAge());

        // 第二种情况 用java.lang包中的类
        String str = "abc";
        System.out.println(str);

        // 其他情况, 发现idea自动导包
        Teacher t = new Teacher();

        // 特殊情况, 同时使用两个包中的同名类, 需要用全类名
        第四个包.demo2.Teacher t2 = new 第四个包.demo2.Teacher();
        第四个包.demo1.Teacher t1 = new 第四个包.demo1.Teacher();
        // 发现不会自动导包, 因为这里如果导包的话上面第21行就报错了
        // 所以推荐上面这样写, 不同包重名就用全类名
    }
}