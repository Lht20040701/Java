package 泛型练习;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("大脸妹");
        list.add("阿衰");
        list.add("李菜菜");

        System.out.println(list);
    }
}
