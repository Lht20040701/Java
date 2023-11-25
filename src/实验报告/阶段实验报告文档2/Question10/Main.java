package 实验报告.阶段实验报告文档2.Question10;

public class Main {
    public static void main(String[] args) {
        Student st = new Student("李菜菜", 19);
        Teacher te = new Teacher("老师", 18);

        st.sleep();
        st.eating();

        te.sleep();
        te.eating();
    }
}
