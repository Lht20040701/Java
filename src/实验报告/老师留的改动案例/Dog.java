package 实验报告.老师留的改动案例;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}
