package Stream流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class FirstUseStream {
    public static void main(String[] args) {
        ArrayList<String> lis1 = new ArrayList<>();
        lis1.add("张无忌-14");
        lis1.add("张三丰-13");
        lis1.add("赵敏-12");
        lis1.add("张强-17");
        lis1.add("周芷若-18");

        String[] arr = lis1.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

        System.out.println(Arrays.toString(arr));

        System.out.println("-----------------------------------------------------");

        String[] arr1 = lis1.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr1));
    }
}
