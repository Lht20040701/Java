package 接口;

public class Test {
    public static void main(String[] args) {
        // 创建青蛙的对象
        Forg f = new Forg("小青", 1);
        System.out.println(f.getName() + ", " + f.getAge());

        f.eat();
        f.swim();

        // 创建兔子的对象
        Rabbit r = new Rabbit("小白", 2);
        System.out.println(r.getName() + ", " + r.getAge());
        r.eat();
        // r.swim(); 没有这个方法
    }
}
