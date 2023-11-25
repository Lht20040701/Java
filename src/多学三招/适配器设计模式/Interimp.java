package 多学三招.适配器设计模式;

public class Interimp extends InterAdapter{
    // 需要用到哪个方法, 就重写哪个方法

    @Override
    public void method5() {
        System.out.println("重写需要用到的第五个方法");
    }
}
