package 练习;

public class Test {
    public static void main(String[] args) {
        manager ma = new manager(1, "张三", 100, 200);
        chef ch = new chef(2, "李四", 50);

        ma.eat();
        ma.work();

        ch.eat();
        ch.work();
    }
}
