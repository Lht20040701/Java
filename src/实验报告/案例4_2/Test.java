package 实验报告.案例4_2;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("李菜菜");
        Dog d = new Dog("小花花");
        Cat c = new Cat("小菜菜");
        p.feed(d);
        p.feed(c);
    }
}
