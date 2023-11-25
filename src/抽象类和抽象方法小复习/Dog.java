package 抽象类和抽象方法小复习;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}
