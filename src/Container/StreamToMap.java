package Container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "李菜菜-男-19", "蜡笔小新-男-5", "哆啦A梦-男-19", "阿衰-男-13", "大脸妹-女-13");

        /**
         *  toMap :
         *          参数1表示键生成的规则
         *          参数2表示值的生成规则
         *
         *  参数1 :
         *          Function泛型1 : 表示流中每一个数据的类型
         *          Function泛型2 : 表示Map集合中键的数据类型
         *
         *          方法apply形参 : 依次表示流里的每一个数据
         *          方法体 : 生成键的代码
         *          返回值 : 已经生成的键
         *
         *
         *  参数2 :
         *          Function泛型1 : 表示流中每一个数据的类型
         *          Function泛型2 : 表示Map集合中值的数据类型
         *
         *          方法apply形参 : 依次表示流里面的每一个数据
         *          方法体 : 生成值的代码
         *          返回值 : 已经生成的值
         *
         *
         *   所以apply方法的返回值和泛型2的数据类型对应, 而apply方法形参的数据类型和泛型1对应
         * */

        // 化简前
        Map<String, Integer> map = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                },
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }
        ));

        System.out.println(map);

        System.out.println("-------------------------------------");

        // 化简后
        Map<String, Integer> m = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[2])
        ));

        System.out.println(m);
    }
}
