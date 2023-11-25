package 测试接口之间的多继承;

public interface add_and_sub extends add, sub{
    final static int c = 2;

    public abstract int mulmethod();
}
