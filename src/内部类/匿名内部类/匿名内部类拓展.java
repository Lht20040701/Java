package 内部类.匿名内部类;

public class 匿名内部类拓展 {
    public static void main(String[] args) {
        // 回顾一下匿名内部类的格式 :
        /**
         *     new 类 / 接口 () {
         *         重写的方法();
         *     }
         */

         // 整体我们可以理解为Swim接口实现类对象
         // 接口的多态
        Swim s = new Swim() {
            @Override
            public void swim() {
                System.out.println("重写swim方法");
            }
        };

        // 编译看左边, 运行看右边
        s.swim();

        new Swim() {

            @Override
            public void swim() {
                System.out.println("重写swim方法");
            }
        }.swim(); // 可以直接调用方法
        // 原因是整体是一个没有名字的对象, 注意是对象, 所以可以调用自己所有的方法

    }
}
