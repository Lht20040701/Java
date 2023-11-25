/********** Begin **********/
//在这里添加包名  step4
package 头歌题目;
//创建类 添加属性和方法
public class WuMingFen {
    private String theMa;
    private int quantity;
    private boolean likeSoup;

    public WuMingFen() {

    }

    public WuMingFen(String theMa, int quantity, boolean likeSoup) {
        this.theMa = theMa;
        this.quantity = quantity;
        this.likeSoup = likeSoup;
    }

    public WuMingFen(String theMa, int quantity) {
        this.theMa = theMa;
        this.quantity = quantity;
    }

    public String getTheMa() {
        return theMa;
    }

    public void setTheMa(String theMa) {
        this.theMa = theMa;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isLikeSoup() {
        return likeSoup;
    }

    public void setLikeSoup(boolean likeSoup) {
        this.likeSoup = likeSoup;
    }

    public void check() {
        System.out.println("面码：" + theMa + "，粉的份量：" + quantity + "两，是否带汤：" + likeSoup);
    }
}



/********** End **********/	