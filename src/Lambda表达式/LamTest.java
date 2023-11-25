package Lambda表达式;

public class LamTest {
    public static void main(String[] args) {
        method(
                () -> {
                    System.out.println("测试");
                }
        );
    }

    public static void method(Swim s) {
        s.swim();
    }
}

@FunctionalInterface
interface Swim {
    public abstract void swim();
}
