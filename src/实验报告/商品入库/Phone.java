package 实验报告.商品入库;

public class Phone {
    private String name;
    private int size;
    private int price;
    private String configuration;
    private int num;

    public long getSum() {
        return (long)num * price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", configuration='" + configuration + '\'' +
                ", num=" + num +
                '}';
    }

    public Phone(String name, int size, int price, String configuration, int num) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.configuration = configuration;
        this.num = num;
    }

    public Phone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
