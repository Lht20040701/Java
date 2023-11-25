package 实验报告.阶段实验报告文档2.Question20;

public class Outer {
    public  void function() {
        Inter i = new Inter() {
            @Override
            public void show() {
                System.out.println("你好, 这里是show方法");
            }

            @Override
            public void method() {
                System.out.println("你好, 这里是method方法");
            }
        };
        i.show();
        i.method();
    }
}
