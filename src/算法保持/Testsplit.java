package 算法保持;

public class Testsplit {
    public static void main(String[] args) {

        String s = "123+i456";

        String[] ss = s.split("\\+i");

        System.out.println(ss[0] + " " + ss[1]);
    }
}
