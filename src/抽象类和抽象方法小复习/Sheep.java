package 抽象类和抽象方法小复习;

public class Sheep extends Animal {
    public Sheep() {
    }

    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃艹");
    }
}
