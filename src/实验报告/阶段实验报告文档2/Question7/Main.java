package 实验报告.阶段实验报告文档2.Question7;

import 实验报告.阶段实验报告文档2.Question1.Student;

public class Main {
    public static void main(String[] args) {
        Student.className = "三年级二班";

        Student[] ss = new Student[3];
        for (int i = 0; i < ss.length; i ++ ) ss[i] = new Student();
        ss[0].setName("李菜菜");
        ss[1].setName("野比大雄");
        ss[2].setName("蜡笔小新");

        for (int i = 0; i < ss.length; i ++ ) System.out.println(ss[i].getName() + " " + Student.className);
    }
}
