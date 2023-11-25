package 内部类.匿名内部类;

public class Test {
    public static void main(String[] args) {
        /*
            需要大家理解匿名内部类的格式, 而不是硬记
            new 类名或者接口名 () {
                重写方法;
            };
         */

        new Swim() { // 重谢Swim这个接口中的抽象  方法

            @Override
            public void swim() {
                System.out.println("重写了游泳的方法");
            }
        };

        new Animal() {

            @Override
            public void eat() {
                System.out.println("重写了eat方法");
            }
        };

        Dog d = new Dog();
        method(d);
        // 以前我们想要调用下面的函数的时候需要写一个子类继承Animal这个类, 然后通过多态实现
        // 但是现在有个问题, 如果现在Dog类对应的这个对象只用这一次, 那么还需要单独定义一个类太麻烦了

        method( // 可以直接通过这种方式, 通过匿名内部类来实现操作, 直接传递过去继承Animal的子类对象
                new Animal() {
                    @Override
                    public void eat() {
                        System.out.println("狗吃骨头");
                    }
                }
        );
    }

    public static void method(Animal a) { // Animal a = 子类对象 多态
        a.eat(); // 执行逻辑 : 编译看左边, 运行看右边
    }
}