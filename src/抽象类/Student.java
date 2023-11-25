package 抽象类;

public class Student extends Person {

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    // 抽象类的子类要么重写抽象类中的所有抽象方法
    // 要么就是抽象类
    // 我们一般采用第一种
    @Override
    public void work() {
        System.out.println("学生的工作是学习");
    }
}
