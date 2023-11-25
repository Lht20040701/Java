package 实验报告.案例10_11改版.example11;

public class Dog implements Animal, Action{
    @Override
    public void eat() {
        System.out.println("喜欢吃骨头");
    }

    @Override
    public void shout() {
        System.out.println("汪汪 ... ");
    }

    @Override
    public void info() {
        System.out.println("名称 : " + Animal.NAME);
    }
}
