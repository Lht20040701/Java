package 实验报告.多功能手机;

public class Phone {
    private String brand;
    private String type;
    private int price;
    private String os;
    private int memory;

    public Phone(String brand, String type, int price, String os, int memory) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.os = os;
        this.memory = memory;
    }

    public Phone() {
    }

    public void about() {
        System.out.println("手机信息={" + "品牌:" + brand + ", 手机型号:" + type + ", 手机价格:" + price + ", 操作系统:" + os + ", 内存大小:" + memory + "}");
    }

    public void call(String no) {
        System.out.println("我在给" + no + "打电话");
    }

    public void playGame(String game) {
        System.out.println("我在用手机玩" + game);
    }

    public void downMusic(String name) {
        System.out.println(name + "太好听辣, 我要存手机上");
    }

    public void playMusic(String name) {
        System.out.println("忽然想听" + name + "辣, 快给我播放");
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
