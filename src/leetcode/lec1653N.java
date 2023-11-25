package leetcode;

public class lec1653N {
    public static void main(String[] args) {

    }

    /**
     * 集合 : f[i], 代表走到i这里的所有处理方式
     * 属性 : 最少的处理次数
     *
     * 转移 :
     * 考虑s的最后一个字符 :
     *      1. 是b :
     *          无需删除, 问题规模得到了减少, 答案就是f[i - 1]
     *      2. 是a :
     *          分两种情况, 我们看那种情况更好就好了
     *          (1).如果选择删除, 答案就是f[i - 1] + 1
     *          (2).如果选择留下, 需要删除前面所有的b
     *
     * 而且发现每个f[i]只和上一层f[i - 1]有关系, 所以可以用滚动数组的思想, 直接优化到一个变量的情况
     * */

    public int minimumDeletions(String s) {
        int f = 0; int cnt = 0;

        for (int i = 0; i < s.length(); i ++ ) {
            if (s.charAt(i) == 'b') cnt++;
            else f = Math.min(f + 1, cnt); // 看留下和删除那个更好
        }

        return f;
    }
}
