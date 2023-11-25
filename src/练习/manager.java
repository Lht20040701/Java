package 练习;

public class manager extends Person{
    private int manageWage;

    public manager() {}

    public manager(int id, String name, int wage, int manageWage) {
        super(id, name, wage);
        this.manageWage = manageWage;
    }

    @Override
    public void work() {
        super.work();
        System.out.println("管理别人");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃米饭");
    }
}
