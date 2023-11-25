package 成员特点和接口的各种关系;

public class Test {
    /*
        成员变量 :
            只能是常量, 默认修饰符 : public static final
        构造方法 :
            没有
         成员方法 : 只能是抽象方法, 默认修饰符 : public abstract
     */
    public static void main(String[] args) {
        System.out.println(Inter.a); // 可以打出来
        // Inter.a = 20; 试图修改发现报错, 说明是final修饰
    }
}
