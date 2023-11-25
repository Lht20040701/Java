package 泛型练习;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericsTest {
    public static void method(ArrayList<? extends Animal> list) {
        list.get(0).eat();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<FlowerCat> list = new ArrayList<>();

        list.add(new FlowerCat());

        method(list);
    }
}
