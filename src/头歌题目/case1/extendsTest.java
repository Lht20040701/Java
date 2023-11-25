package 头歌题目.case1;

public class extendsTest {
    public static void main(String args[]) {
        // 实例化一个Cat对象，设置属性name和age，调用voice()和eat()方法，再打印出名字和年龄信息
        /********* begin *********/
        Cat c = new Cat("大花猫", 6);
        c.voice();
        c.eat();
        c.getMessage();
        /********* end *********/

        // 实例化一个Dog对象，设置属性name和age，调用voice()和eat()方法，再打印出名字和年龄信息
        /********* begin *********/
        Dog d = new Dog("大黑狗", 8);
        d.voice();
        d.eat();
        d.getMessage();
        /********* end *********/

    }
}

class Animal {
    /********* begin *********/
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
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

    public void getMessage() {
        System.out.println(getName() + getAge() + "岁");
    }

    public void voice() {
        System.out.println("发出声音");
    }

    public void eat() {
        System.out.println("吃东西");
    }
    /********* end *********/

}

class Cat extends Animal {
    // 定义Cat类的voice()和eat()方法
    /********* begin *********/
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println(getName() + "喵喵叫");
    }

    @Override
    public void eat() {
        System.out.println(getName() + "吃鱼");
    }


    /********* end *********/
}

class Dog extends Animal {
    // 定义Dog类的voice()和eat()方法
    /********* begin *********/
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println(getName() + "汪汪叫");
    }

    @Override
    public void eat() {
        System.out.println(getName() + "吃骨头");
    }
    /********* end *********/
}