package 头歌题目.case4;

public class interfaceTest {
    public static void main(String[] args) {
        // 实例化一Student的对象s，并调用talk()方法，打印信息
        /********* begin *********/
        Student s = new Student();
        s.talk();
        /********* end *********/

    }
}

// 声明一个Person接口，并在里面声明三个常量：name、age和occupation，并分别赋值，声明一抽象方法talk()
interface Person {
    /********* begin *********/
    final String name = "张三";
    final int age = 18;
    final String occupation = "学生";
    public abstract void talk();
    /********* end *********/
}

// Student类继承自Person类 复写talk()方法返回姓名、年龄和职业信息
class Student implements Person {
    @Override
    public void talk() {
        System.out.println("学生——>姓名：" + name + "，年龄："+ age + "，职业："+ occupation + "！");
    }
    /********* begin *********/

    /********* end *********/
}