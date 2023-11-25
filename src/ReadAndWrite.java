import java.io.*;
import java.util.StringTokenizer;

public class ReadAndWrite {
    public static void main(String[] args) throws IOException { // 需要手动抛异常
        Read sc = new Read(); // 快读 (输入超过十万 10^5 的时候用
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); // 快写 (输出超过十万 10^5 的时候用

        int a = sc.nextInt(), b = sc.nextInt(); // 快读和Scanner的使用方法一致
        out.write(a + b + ""); // 快写需要调用write方法, 然后最后一定要加一个字符串转化一下 (非常重要
        out.close(); // 程序最后需要手动刷一下flush或者直接关掉close让缓冲区中的输出出来 (非常重要
    }
}

// 使用的时候注意抛出异常throws IOException
class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
// 重写别的快读的时候格式都差不多
}