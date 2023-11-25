package 成员特点和接口的各种关系;

public interface Inter {
    // public static final
    int a = 10;

    // public abstract
    void method();

    // 然后通过内存分析工具发现接口中是没有构造方法的
}
