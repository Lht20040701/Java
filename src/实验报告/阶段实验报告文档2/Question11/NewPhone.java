package 实验报告.阶段实验报告文档2.Question11;

public class NewPhone extends Phone {
    @Override
    public void call() {
        super.call();
        System.out.println("我是NewPhone我还能开关语言(更自豪)");
    }
}
