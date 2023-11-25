package lambdai表达式遍历;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("李菜菜");
        list.add("阿衰");
        list.add("大脸妹");
        list.add("令狐冲");
        list.add("死党");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach(s -> System.out.println(s));
    }
}
