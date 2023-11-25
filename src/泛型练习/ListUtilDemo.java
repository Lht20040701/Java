package 泛型练习;

import java.util.ArrayList;

public class ListUtilDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        ListUtil.addAll(list, "大脸妹", "阿衰", "李菜菜", "哆啦A梦", "蜡笔小新");
        System.out.println(list);
    }
}
