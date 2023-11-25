package 实验报告.阶段实验报告文档2.Question2;

import 实验报告.阶段实验报告文档2.Question1.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(19);
        s1.speak();

        Student s2 = new Student();
        s2.setName("李四");
        s2.setAge(20);
        s2.speak();

        Student s3 = s2;
        s3.speak();
    }
}
