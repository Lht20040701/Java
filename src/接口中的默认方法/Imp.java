package 接口中的默认方法;

public class Imp implements Inner {

    @Override
    public void mothod1() {
        System.out.println("你好, 这里是实现类Imp重写的接口中的抽象方法method1");
    }

//    @Override
//    public void method2() {
//        System.out.println("你好, 这里是实现类Imp重写的接口中的默认方法method2");
//    }
}
