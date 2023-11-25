package 实验报告.阶段实验报告文档2.思考一下_除数;

public class Division {
    private int dividend;
    private int divisor;

    public Division() {
        dividend = 1;
        divisor = 1;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        if (divisor == 0) System.out.println("除数不能为0");
        else this.divisor = divisor;
    }

    @Override
    public String toString() {
        return "Division{" +
                "dividend=" + dividend +
                ", divisor=" + divisor +
                '}';
    }
}
