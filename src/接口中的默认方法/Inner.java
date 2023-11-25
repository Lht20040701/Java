package 接口中的默认方法;

public interface Inner {
    public abstract void mothod1();

    public default void method2() {
        System.out.println("你好, 这里是接口Inner中的默认方法method2");
    }
}
