package 实验报告.案例10_11改版.example11;

public interface Animal {
    static final int ID = 1;
    static final String NAME = "牧羊犬";
    public abstract void shout();

    public static int getid() {
        return ID;
    }

    public abstract void info();
}
