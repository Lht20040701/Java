package 多学三招.静态;

public interface Inter {

    public abstract void method();

    public static void show() {
        System.out.println("Inter接口中的静态方法");
    }
}