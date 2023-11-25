package 内部类;

public class Car {
    String carName;
    int carAge;
    String carColor;

    public void show(Car this) {
        System.out.println(this.carName);
        //  System.out.println(engineName);
        // 发现报错, 也就是说不可以直接访问内部类中的成员

        Engine e = new Engine();
        System.out.println(e.engineName);
        // 这样子就可以了
        // 原因是之前我们提到过, 有隐藏的this关键字
        // this是虚拟机自动将调用者的地址赋值过去的
        // 所以最开始this.carName是正确的, 但是this.engineName就找不到了
        // 所以需要创建子类的对象进行访问
    }

    class Engine {
        String engineName;
        int engineAge;

        public void show() {
            System.out.println(engineName);

            // 内部类可以直接访问外部类的成员, 包括私有
            System.out.println(carName);
        }
    }
}
