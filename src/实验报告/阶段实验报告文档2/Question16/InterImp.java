package 实验报告.阶段实验报告文档2.Question16;

public class InterImp implements Inter {

    @Override
    public void method() {
        System.out.println("我实现了接口的方法, 并且接口中默认public final常量");
        System.out.println("接口中的常量" + NUM);
    }
}
