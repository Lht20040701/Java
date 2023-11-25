package 内部类.创建成员内部类;

public class Test {
    public static void main(String[] args) {
        /*
            编写成员内部类的注意点 :
                1. 成员内部类可以被一些修饰符所修饰, 比如 : private, 默认 : protected, public, static等
                2. 在成员内部类里面, JDK16之前不能定义静态变量, JDk16开始才可以定义静态变量.

            获取成员内部类对象的两种方式 :
                方式1 : 外部类编写方法, 对外提供内部类对象.
                方式2 : 直接创建.
                格式 : 外部类名.内部类名 对象名 = 外部类对象.内部类对象;
                范例 : Outer.Inner oi = new Outer().new Inner();
         */

        // 以前创建对象的方式 :
        // 类名 对象名 = new 类名();
        // Sutdent s = new Student();

        // 如何创建内部类的对象 :
//        Outer.Inner oi = new Outer().new Inner();
        // 这里报错的原因是我加了private私有关键字, 不让外界创建私有内部类的对象

        // 理解 : 之前说过成员内部类的地位和成员方法的地位是相同的
        // 先是创建内部类的时候需要写上是哪个外部类里面的内部类
        // 所以调用的时候需要知道调用者是谁, 所以就先new外部类, 然后再new内部类, 再返回内部类的地址赋值给oi
        // 这里就好比之前调用成员变量的时候
        // s.name可以, 然后new Student().name也可以, 利用new关键字返回的新建对象的地址进行调用name这个成员变量
        // 所以上面可以通过new Outer().new Inner();创建内部类

        Outer o = new Outer();
//        Outer.Inner inner = o.getInstance();
        // 可以看到上面这句话报错了, 原因是因为这东西私有化以后外界都不知道Outer有Inner这个类
        // 有两种解决方式 :
        Object inner = o.getInstance();
        // 利用多态, 使用外部类的父类接收, 这里是Object

        System.out.println(o.getInstance());
        // 第二种方式更推荐, 直接用就可以了
    }
}
