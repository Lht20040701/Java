package 多学三招;

public interface InterB {
    public default void show() {
        System.out.println("接口B中的默认方法 ---- show");
    }
}
