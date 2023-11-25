package 方法引用;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionDemo1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 6, 5, 2, 1}; // 注意这里还得引用数据类型

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

//        Arrays.sort(arr, (o1, o2) -> o2 - o1);
//
//        Arrays.sort(arr, FunctionDemo1::subtraction);
//
//        System.out.println(Arrays.toString(arr));
    }

    public static int subtraction(Integer num1, Integer num2) {
        return num2 - num1;
    }
}