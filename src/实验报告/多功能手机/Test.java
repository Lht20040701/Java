package 实验报告.多功能手机;

public class Test {
    public static void main(String[] args) {
        Phone p = new Phone("苹果", "iPhoneX", 8888, "ios", 16);

        p.about();
        p.call("10086");
        p.playGame("使劲叫唤");
        p.playMusic("DJ");
        p.downMusic("DJ");

        Phone hw = new Phone("华为", "华为荣耀mete 60 pro", 6666, "鸿蒙OS", 16);
        hw.about();
        hw.call("10086");
        hw.playGame("暴打苹果的114514次");
        hw.playGame("遥遥领先进行曲");
        hw.downMusic("遥遥领先进行曲");
    }
}
