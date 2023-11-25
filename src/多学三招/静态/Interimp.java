package 多学三招.静态;

public class Interimp implements Inter {
    @Override
    public void method() { // 发现只需要重写抽象方法就好了
        System.out.println("重写的抽象方法");
    }

    // 这不叫重写, 用Interimp.show()访问的就是这里的show, Inter.show()访问的就是Inter中的show
    public static void show() {
        System.out.println("Interimp中的重名静态方法");
    }
}
