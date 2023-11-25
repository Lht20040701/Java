package 实验报告.阶段实验报告文档2.Question3;

import 实验报告.阶段实验报告文档2.Question1.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("你好");
        s.setAge(-30);
        s.speak();
        s.setAge(10);
        s.speak();
    }
}
