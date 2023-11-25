package 实验报告.老师留的改动案例;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
