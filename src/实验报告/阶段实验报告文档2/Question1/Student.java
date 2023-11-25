package 实验报告.阶段实验报告文档2.Question1;

public class Student {
    private String name;
    private int age;
    public static String className;

    public Student() {
        System.out.println("我是无参构造方法");
    }

    public Student(String name) {
        this();
        System.out.println("我是一个参数的构造方法");
        this.name = name;
    }

    public Student(String name, int age) {
        this(name);
        System.out.println("我是两个参数的构造方法");
        this.age = age;
    }

    public void speak() {
        System.out.println("Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}');
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
        if (age < 0) System.out.println("输入的年龄不合法");
        else this.age = age;
    }
}
