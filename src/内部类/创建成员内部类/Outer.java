package 内部类.创建成员内部类;

public class Outer {
    private class Inner {
    }

    public Inner getInstance() {
        return new Inner();
    }
}
