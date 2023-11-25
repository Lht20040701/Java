package 实验报告.阶段实验报告文档2.Question6;

import 实验报告.阶段实验报告文档2.Question1.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------调用了无参-----------------------------");
        Student s3 = new Student();
        System.out.println("--------------------------调用了一参-----------------------------");
        Student s2 = new Student("你好");
        System.out.println("--------------------------调用了二参-----------------------------");
        Student s1 = new Student("你好", 19);
    }
}
