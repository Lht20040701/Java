package 实验报告.案例10_11改版.example11;

public class Test {
    public static void main(String[] args) {
        System.out.println("编号" + Animal.getid());
        Dog d = new Dog();
        d.info();
        d.shout();
        d.eat();
    }
}
