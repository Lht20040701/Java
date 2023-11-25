package 抽象类;

public class Test {
    public static void main(String[] args) {
        // Person p = new Person(); 抽象类不能被实例化, 抽象类不能创建对象

        Student st = new Student("李菜菜", 18);
        System.out.println(st.getName() + ", " + st.getAge());
        st.work();
    }
}
