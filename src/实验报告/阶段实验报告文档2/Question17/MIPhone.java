package 实验报告.阶段实验报告文档2.Question17;

public class MIPhone implements SmartPhone {
    @Override
    public void receiveMessages() {
        System.out.println("我是重写的receiveMessages");
    }

    @Override
    public void call() {
        System.out.println("我是重写的call");
    }

    @Override
    public void faceTime() {
        System.out.println("我是重写的faceTime");
    }

    public void useMIUI() {
        System.out.println("我是useMIUI");
    }
}
