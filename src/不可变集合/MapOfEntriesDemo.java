package 不可变集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapOfEntriesDemo {
    public static void main(String[] args) {
        HashMap<String, String> m = new HashMap<>();
        m.put("李菜菜", "濮阳");
        m.put("大脸妹", "趴体市");
        m.put("阿衰", "趴体市");
        m.put("蜡笔小新", "埼玉县");
        m.put("哆啦A梦", "东京");
        m.put("大雄", "东京");
//        利用上面的数据获取一个不可变的集合

//        按步骤一步一步讲解
//        目的是把entries变成一个数组

//        第一步 : 获取到所有的键值对对象(Entry对象), 利用Map中的entrySet
        Set<Map.Entry<String, String>> entries = m.entrySet();


        Map.Entry<String, String>[] arr1 = new Map.Entry[0]; // 这里后面一定要是一个普通数组, Java为了防止报错, 所以禁止泛型数组
        // 这一步我独特的理解, 后面虽然是普通数组, 但是给前面以后就成泛型了
        // arr1的目的是给toArray参数好成功调用toArray

//        toArray方法在底层会比较集合长度跟数组长度两者的大小
//        如果集合的长度 >  数组的长度 : 数据在数组中放不下, 此时会根据实际数据的个数, 重新创建数组
//        如果集合的长度 <= 数组的长度 : 数据在数组中放得下, 此时不会创建新的数组, 而是直接用
        Map.Entry<String, String>[] arr2 = entries.toArray(arr1);
        // arr2这时候就是Entry数组了, 接下来只要把他作为参数传给ofEntries就好了

//        不可变的map集合构建成功
        Map<String, String> smap = Map.ofEntries(arr2);
        smap.forEach((k, v) -> System.out.println(k + " " + v));





//        综上上方一大堆, 直接一步到位
        Map<String, String> sm = Map.ofEntries(m.entrySet().toArray(new Map.Entry[0]));
        sm.forEach((k, v) -> System.out.println(k + " " + v));


//        因为上面那个代码太长了,Java防止我们记不住, 所以帮我们写好了, copyOf返回一个不可变Map, 底层调用就是上方那句话 (JDK10以后才有)
        Map<String, String> stmap = Map.copyOf(m);
        stmap.forEach((k, v) -> System.out.println(k + " " + v));

    }
}