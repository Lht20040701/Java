package 泛型练习;

import java.util.ArrayList;

public class GenericsNoExtend {
    public static void main(String[] args) {
        ArrayList<Ye> list1 = new ArrayList<>();
        ArrayList<Fu> list2 = new ArrayList<>();
        ArrayList<Zi> list3 = new ArrayList<>();
        ArrayList<AnotherClass> list4 = new ArrayList<>();

        method(list1);
        method(list2);
        method(list3);
//        method(list4);
    }

    public static void method(ArrayList<? extends Ye> list) {
         // 方法体
    }
}

class Ye {

}

class Fu extends Ye {

}

class Zi extends Fu {

}

class AnotherClass {

}
