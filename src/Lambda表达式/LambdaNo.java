package Lambda表达式;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaNo {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 5, 6, 7, 8, 9, 4};

        // 匿名内部类写法
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 花间前
        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });

        // 化简后
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
    }
}
