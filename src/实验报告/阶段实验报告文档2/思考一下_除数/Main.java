package 实验报告.阶段实验报告文档2.思考一下_除数;

public class Main {
    public static void main(String[] args) {
        Division d = new Division();
        d.setDividend(2);
        d.setDivisor(0);
        System.out.println(d.toString());

        d.setDivisor(2);
        System.out.println(d.toString());
    }
}
