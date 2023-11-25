package 多学三招;

public class Interimp implements InterA, InterB {

    @Override
    public void method() {
        System.out.println("实现类重写的抽象方法");
    }

    @Override
    public void show() { // 前面不可以加上default关键字
        System.out.println("重写接口中的默认方法");
    } // 因为接口A, B中都有show这个默认方法, 所以必须重写
}
