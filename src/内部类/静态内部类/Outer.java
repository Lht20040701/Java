package 内部类.静态内部类;

public class Outer {

    int a = 10;
    static int b = 20;

    // 静态内部类
    static class Inner {
        public void show1() {
            System.out.println("非静态的方法被调用了");
//            System.out.println(a);
            // 上面这句话发现报错;
            System.out.println(b); // 但是调用静态的就没有问题

            Outer o = new Outer();
            System.out.println(o.a);
            // 创建对象以后访问发现就没有什么问题了
        }

        public static void show2() {
            System.out.println("静态的方法被调用了");
        }
    }
}
