package 实验报告.阶段实验报告文档2.Question19;

public class Main {
    public static void main(String[] args) {
        Animal a = new Cat();
        Pig p;
        if (a instanceof Pig) p = (Pig) a; // 不会转型, 因为a既是Animal类也是Cat类
    }
}
