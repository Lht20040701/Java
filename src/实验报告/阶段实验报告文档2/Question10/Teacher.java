package 实验报告.阶段实验报告文档2.Question10;

public class Teacher extends Person {

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher() {
    }

    @Override
    public void sleep() {
        System.out.println("老师睡大床房");
    }

    @Override
    public void eating() {
        System.out.println("老师下馆子");
    }
}
