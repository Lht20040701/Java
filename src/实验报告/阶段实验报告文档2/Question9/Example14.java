package 实验报告.阶段实验报告文档2.Question9;

public class Example14 {
    public static void main(String[] args) {
        Example14 ex14 = new Example14();
        ex14.test();
    }
    public void test() {
        int num = 5;
        class Inner {
            public void show() {
                System.out.println(num);
            }
        }

        Inner ier = new Inner();
        ier.show();
    }
}
