package 练习;

public class Person {
    private int id;
    private String name;
    private int wage;

    public Person() {
    }

    public Person(int id, String name, int wage) {
        this.id = id;
        this.name = name;
        this.wage = wage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void work() {
        System.out.println("工作中");
    }

    public void eat() {
        System.out.println("在吃饭");
    }
}
