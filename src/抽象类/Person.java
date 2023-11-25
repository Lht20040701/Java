package 抽象类;

public abstract class Person {
    private String name;
    private int age;

    // 抽象类中可以有构造方法
    // 作用是当创建子类的时候, 给属性赋值
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void work();

    public void sleep() { // 把上面那个抽象方法注释以后发现抽象类中不一定必须有抽象方法
        System.out.println("睡觉"); // 但是把类定义中的abstract去掉以后就会报错
    }
    // 所以有抽象方法的类一定是抽象类
}