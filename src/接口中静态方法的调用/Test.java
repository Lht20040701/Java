package 接口中静态方法的调用;

public class Test {
    public static void main(String[] args) {
        Imp im = new Imp();

        Inner.method();
//        im.method();
    }
}
