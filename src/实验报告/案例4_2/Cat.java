package 实验报告.案例4_2;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}
