package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lec638N {
    public static void main(String[] args) {

    }
    int ans = 0x3f3f3f3f;
    List<Integer> price; // 价格表
    List<List<Integer>> special; // 礼包
    List<Integer> needs; // 清单
    HashMap<Integer, Integer> ha = new HashMap<>(); // 记录一个礼包最多可以买多少次
    int n;
    int m;

    public int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> _needs) {
        price = _price; special = _special; needs = _needs; // 技巧之leetcode怎么转变全局变量

        n = needs.size(); // 一共有多少个物品

        // 预处理单买 -> 礼包
        ArrayList<Integer> tem = new ArrayList<>();
        for (int i = 0; i < n; i ++ ) tem.add(0); // 初始化
        for (int i = 0; i < n; i ++ ) {
            ArrayList<Integer> clone = new ArrayList<>(tem); // 新技能get, 直接克隆处理, 厉害啊
            clone.set(i, 1);
            clone.add(price.get(i));
            special.add(clone);
        }

        // 预处理每个礼包可以买最多可以买多少个
        m = special.size();
        for (int i = 0; i < m; i ++ ) {
            int k = 0x3f3f3f3f;
            List<Integer> x = special.get(i); // 获取第i个礼包
            for (int j = 0; j < n; j ++ ) {
                int a = needs.get(j); int b = x.get(j); // a代表我需要买几个, b代表我一个礼包可以买几个这东西
                if (a < b) { // 我需要的还没这一个礼包多, 根据题意, 这个礼包不可以买
                    k = 0;
                    break;
                }
                if (b == 0) continue; // 如果这个礼包不包含第i个物品, 看他包含别的物品就行了
                k = k == 0 ? a / b : Math.min(k, a / b);
            }
            ha.put(i, k); // 哈希表记录第i个礼包可以买多少个
        }

        // 搜索
        dfs(0, 0, needs);

        return ans;
    }

    public void dfs(int u, int cur, List<Integer> lis) { // u代表我遍历到了第几个礼包, cur代表我当前的花费, lis代表我当前还需要处理的物品清单
        if (cur >= ans) return ; // 剪枝 -> 当前分支的花费已经超过记录过的最小值了, 退掉就好了

        int cnt = 0;
        for (int i = 0; i < n; i ++ ) cnt += lis.get(i);
        if (cnt == 0) { // 更新答案 + 剪枝 -> 当前分支已经没有物品了, 退掉, 并且如果可以走到这里, 那么花费一定比ans小, 因为最开始的if没有刷掉
            ans = cur;
            return ;
        }

        if (u == m) return ; // 最深层递归完了结束就好了

        List<Integer> x = special.get(u); // 当前礼包最多可以买多少个
        int k = ha.get(u);
        // 技巧之out退掉外层循环
        out:for (int i = 0; i <= k; i ++ ) { // 枚举我买i个第u礼包的情况
            List<Integer> clis = new ArrayList<>(lis); // 因为下面需要修改清单进行递归, 为了还原现场, 所以这里克隆一下
            for (int j = 0; j < n; j ++ ) {
                int a = clis.get(j); int b = x.get(j); // a代表清单上第j个物品我还有几个没处理完, b代表我礼包一次可以处理几个j物品
                if (a < b * i) break out; // 如果当前分支买i个第u礼包的时候就不符合要求了, 直接退掉最外层循环就好了
                clis.set(j, a - b * i);
            }
            dfs(u + 1, cur + i * x.get(n), clis); // 进入下层循环枚举下一个礼包, 把当前的花费传下一层, 修改完的清单也传下一层
        }
    }
}
