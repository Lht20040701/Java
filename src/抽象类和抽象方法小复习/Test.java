package 抽象类和抽象方法小复习;

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog("Dog", 1);
        Frog f = new Frog("Frog", 1);
        Sheep s = new Sheep("Sheep", 1);

        d.eat();
        f.eat();
        s.eat();
    }
}
