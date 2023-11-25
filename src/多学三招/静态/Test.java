package 多学三招.静态;

public class Test {
    public static void main(String[] args) {
        /*
            接口中静态方法的定义格式 :
                格式 : public static 返回值类型 方法名 ( 参数列表 ) {  }
                范例 : public static void show() {  }

            接口中静态方法的注意事项 :
                静态方法只能通过接口名调用, 不能通过实现类名或者对象调用
                public 可以省略, static不能省略
         */

        // 调用接口中的静态方法
        Inter.show();

        // 调用实现类中的静态方法
        Interimp.show();

        // 子类把从父类继承下来的虚方法表里面的方法进行覆盖了, 这才叫重写
        // 但是带有static关键字的方法是不会被添加到虚方法表中的, 所以不叫重写
        // 这是一个小细节
    }
}
