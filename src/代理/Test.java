package 代理;

public class Test {
    /**
     * 需求 : 外面的人想要大明星超一首歌
     * 1. 获取代理的对象
     *      Proxy.Util.creatProxy(大明星的对象)
     * 2. 再调用代理的唱歌方法
     *      代理对象.唱歌的方法("只因你太美");
     * */

    public static void main(String[] args) {
//    1. 获取代理的对象
        BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.creatProxy(bigStar); // 通过接口接受代理对象和调用代理的方法

//    2. 调用唱歌的方法
        String result = proxy.sing("只因你太美"); // 通过接口接受代理对象和调用代理的方法
        System.out.println(result); // 打印返回的结果

//    3. 调用跳舞的方法
        proxy.dance();
    }
}
