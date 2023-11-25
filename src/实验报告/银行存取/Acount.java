package 实验报告.银行存取;

public class Acount {
    private String userName;
    private int leftMoney;

    public Acount(String userName, int leftmoney) {
        this.userName = userName;
        this.leftMoney = leftmoney;
    }

    public Acount() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLeftmoney() {
        return leftMoney;
    }

    public void setLeftmoney(int leftmoney) {
        this.leftMoney = leftmoney;
    }

    public void savemoney(int money) {
        System.out.print("存了" + money + "元, ");
        leftMoney += money;
        System.out.println("余额" + leftMoney);
    }

    public void getmoney(int money) {
        System.out.print("取走了" + money + "元, ");
        leftMoney -= money;
        System.out.println("余额" + leftMoney);
    }

    public void getleftMoney() {
        System.out.println("当前余额有" + leftMoney);
    }
}
