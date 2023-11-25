package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类的作用 : 创建一个代理
 * */

public class ProxyUtil {
    /**
     * 方法的作用 : 给一个明星的对象, 创建一个代理
     * 形参 : 被代理的明星对象
     * 返回值 : 给明星创建的代理
     *
     * 需求 : 外面的人想要大明星超一首歌
     * 1. 获取代理的对象
     *      Proxy.Util.creatProxy(大明星的对象)
     * 2. 再调用代理的唱歌方法
     *      代理对象.唱歌的方法("只因你太美");
     * */

    public static Star creatProxy(BigStar bigStar) {
        /**
         * public static Object newProxyInstance(ClassLoader loader，Class<?> interfaces， InvocationHandler h)
         * 参数一:用于指定用哪个类加载器，去加载生成的代理类
         * 参数二:指定接口，这些接口用于指定生成的代理长什么，也就是有哪些方法
         * 参数三:用来指定生成的代理对象要干什么事情
         * */

        Star star = (Star) Proxy.newProxyInstance( // 通过接口接受代理对象和调用代理的方法
                ProxyUtil.class.getClassLoader(), // 参数一:用于指定用哪个类加载器，去加载生成的代理类, 这里我们用的就是ProxyUtil这个类去生成的代理, 所以把他的加载器写进来
                new Class[]{Star.class}, // 参数二:指定接口，这些接口用于指定生成的代理长什么，也就是有哪些方法, 如果有多个接口, 这里就可以传多个接口
                new InvocationHandler() { // 参数三:用来指定生成的代理对象要干什么事情 (最难的一部分)
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 注意这个方法是指定生成的对象需要做什么事情 !!!!, 以后用代理中的方法的时候走的就是这里的代码
                        /**
                         * 参数1 : 代理的对象
                         * 参数2 : 要运行的方法 sing
                         * 参数3 : 要调用sing方法时, 传递的参数
                         */

                        // 以后生成的代理对象运行的代码就是下面这里的部分
                        if ("sing".equals(method.getName())) { // 通过字符串来判断代理该调用哪个代码
                            System.out.println("准备话筒, 收钱"); // 这里就相当于代理干的事情, 给大明星这个类中的唱歌方法增加的额外功能
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地, 收钱");
                        }

                        // 代理的事情做完了, 现在要去找大明星开始唱歌或者跳舞
                        // 代码的表现形式 : 调用大明星里面唱歌或者跳舞的方法
                        return method.invoke(bigStar, args); // 这里的invoke是之前学反射时说的Method类中的那个执行方法的invoke
                        // 第一个参数时执行方法的对象, 第二个参数是该方法的形参, 我们上面自己写的这个invoke传过来的args就是干这个用的
                    }
                }
        );
        return star;
    }
}
