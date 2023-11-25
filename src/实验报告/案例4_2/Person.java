package 实验报告.案例4_2;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void feed(Animal a) {
        System.out.println(this.name + "喂养了" + a.getName());
        if (a instanceof Dog) System.out.print("因为" + a.getName() + "是狗, 所以发出了");
        if (a instanceof Cat) System.out.print("因为" + a.getName() + "是猫, 所以发出了");
        a.shout();
    }
}
