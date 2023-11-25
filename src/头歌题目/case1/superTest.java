package 头歌题目.case1;

public class superTest {
    public static void main(String[] args) {
        // 实例化一个Student类的对象s，为Student对象s中的school赋值，打印输出信息
        /********* begin *********/
        Student st = new Student("张三", 18, "哈弗大学");
        System.out.println("姓名：" + st.getName() + "，年龄：" + st.getAge() + "，学校：" + st.getSchool());
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

    /********* end *********/
}

class Student extends Person {
    /********* begin *********/
    private String school;

    public Student() {
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    /********* end *********/
}
