package 实验报告.阶段实验报告文档2.Question15;

public class Zi extends Fu {
    public void method() {
        System.out.println("尝试进行访问父类中的常量和修改常量");
        System.out.println(super.x); // 可以通过super进行访问
        System.out.println(x); // 也可以直接访问, 只要不是private私有的都是可以直接访问的
//        super.x == 0; // 这里会报错
    }
}
