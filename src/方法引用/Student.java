package 方法引用;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    // 专门为方法引用添加的构造方法
    /**
     * 可能有的疑问 : 一定要再写一个构造方法吗 ?
     * 答 : 需要, 因为我们方法引用的一个条件就是, 需要被引用的方法的形参列表和返回值类型, 必须和被引用的方法的形参列表和返回值类型一致.
     * 也就是上面的apply方法
     * 所以我们原本的两个构造方法无法满足我们的需求
     * */
    public Student(String s) {
        this.name = s.split("-")[0];
        this.age = Integer.parseInt(s.split("-")[1]);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
