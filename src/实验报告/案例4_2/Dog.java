package 实验报告.案例4_2;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}
