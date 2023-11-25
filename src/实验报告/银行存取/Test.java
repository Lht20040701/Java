package 实验报告.银行存取;

public class Test {
    public static void main(String[] args) {
        Acount ac = new Acount("123456", 500);

        ac.savemoney(1000);
        ac.getmoney(2000);
    }
}
