package 实验报告.商品入库;

public class WarehousingDemo {
    public static void main(String[] args) {

        Phone huawei = new Phone("华为", 2, 3999, "遥遥领先", 114514);
        Phone mi = new Phone("小米", 1, 2999, "为发烧而生", 1919810);

        System.out.println(huawei.toString());
        System.out.println(mi.toString());

        System.out.println("总库存是 : " + (huawei.getNum() + mi.getNum()));
        System.out.println("库存商品总金额是 : " + ((long)huawei.getSum() + mi.getSum()));
    }
}
