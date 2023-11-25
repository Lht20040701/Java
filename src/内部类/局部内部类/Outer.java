package 内部类.局部内部类;

public class Outer {

    int b = 20; // 外部类中的成员变量

    public void show() {
        int a = 10; // 方法中的局部变量
        // 什么东西可以修饰局部变量, 什么东西就可以修饰局部内部类, (这句话还是挺有用的
        // 比如, final可以修饰局部变量, 同样, final也可以修饰局部内部类
        // 又如public不可以修饰局部变量, 因为这个东西是给成员变量用的, 所以这个东西是不能修饰局部内部类的
        // private, protected同样的道理, 不能作用于局部变量, 和局部内部类

        // 局部内部类
        class Inner {
            String name; // 内部类中的成员变量
            int age;

            public void method1() { // 局部内部类中的成员方法
                System.out.println(a); // 可以访问方法中的局部变量
                System.out.println(b); // 也可以直接访问外部类的成员
                System.out.println("局部内部类中得到method方法1");
            }

            public static void method2() {
                System.out.println("局部内部类中的method2静态方法");
            }
        }

        // 创建局部内部类的对象
        Inner i = new Inner(); // 外界是无法直接使用局部内部类, 需要在方法内部创建对象并使用
        System.out.println(i.name);
        i.method1();
        Inner.method2();
    }
}
