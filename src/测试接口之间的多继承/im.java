package 测试接口之间的多继承;

public class im implements add_and_sub{
    @Override
    public int addmethod() {
        return add.x + add.y;
    }

    @Override
    public int mulmethod() {
        return addmethod() * submethod();
    }

    @Override
    public int submethod() {
        return sub.x - sub.y;
    }
}
