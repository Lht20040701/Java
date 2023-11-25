package 多学三招.私有;

public interface InterA {
    public default void show1() {
        System.out.println("show1方法开始执行了");
        show3();
    }

    public default void show2() {
        System.out.println("show2方法开始执行了");
        show3();
    }

    // 普通的私有方法, 给默认弱方法服务的
    private void show3() {
        System.out.println("记录程序运行中的各种细节, 这里有100行代码");
    }

    // 如果上面show1和show2都是静态方法的话, 那么应该调用这个方法, 因为静态只能调用静态
    private static void show4() {
        System.out.println("记录程序运行中的各种细节, 这里有100行代码");
    }

}
