package 练习;

public class chef extends Person{
    public chef() {}

    public chef(int id, String name, int wage) {
        super(id, name, wage);
    }

    @Override
    public void work() {
        super.work();
        System.out.println("炒菜");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃米饭");
    }
}
