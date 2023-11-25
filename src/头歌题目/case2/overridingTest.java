package 头歌题目.case2;

import javax.swing.text.Style;

public class overridingTest {
    public static void main(String[] args) {
        // 实例化子类对象s，调用talk()方法打印信息
        /********* begin *********/
        Student st = new Student("张三", 18, "哈佛大学");
        st.talk();
        /********* end *********/

    }
}

class Person {
    /********* begin *********/
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String take() {
        return "我是：" + name + "，今年：" + age + "岁";
    }
    /********* end *********/
}

class Student extends Person {
    /********* begin *********/
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public void talk() {
        System.out.println(super.take() + "，我在" + school + "上学");
    }
    /********* end *********/
}