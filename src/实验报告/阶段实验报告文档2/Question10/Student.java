package 实验报告.阶段实验报告文档2.Question10;

public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public Student() {
    }

    @Override
    public void sleep() {
        System.out.println("学生睡大觉");
    }

    @Override
    public void eating() {
        System.out.println("学生吃盒饭");
    }
}
