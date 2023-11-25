package 实验报告.阶段实验报告文档2.Question8;

public class Example10 {
    public static void staticMethod1() {
        System.out.println("我是静态方法staticMethod1");
        Example10.staticMethod2();
//        nonStaticMethod1();报错
//        nonStaticMethod2();报错
    }

    public static void staticMethod2() {
        System.out.println("我是静态方法staticMethod2");
        Example10.staticMethod1();
//        nonStaticMethod1();报错
//        nonStaticMethod2();报错
    }

    public void nonStaticMethod1() {
        System.out.println("我是非静态方法nonStaticMethod1");
        staticMethod1();
        staticMethod2();
        nonStaticMethod2();
    }

    public void nonStaticMethod2() {
        System.out.println("我是非静态方法nonStaticMethod2");
        staticMethod1();
        staticMethod2();
        nonStaticMethod1();
    }
}
