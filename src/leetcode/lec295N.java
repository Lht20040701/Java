package leetcode;

import java.util.PriorityQueue;

/**
 * 日常没写出来, 已经麻木了 :
 *      三叶姐姐的题解 : https://leetcode.cn/problems/find-median-from-data-stream/solutions/961319/gong-shui-san-xie-jing-dian-shu-ju-jie-g-pqy8/?envType=study-plan-v2&envId=top-100-liked
 *
 *      思路 : 用一个大根堆维护左半子序列, 一个小根堆维护右半子序列
 *      当两个堆的元素个数相等时 (也就是添加了偶数个数时) , 取两个堆顶元素的平均数作为中位数
 *      否则当添加了奇数个数时, 我们维护左半子序列的大根堆的堆顶为答案
 *
 *      具体分类讨论看题解
 * */
class MedianFinder {
    PriorityQueue<Integer> pl;
    PriorityQueue<Integer> pr;

    public MedianFinder() {
        pl = new PriorityQueue<>((a, b) -> b - a);
        pr = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int ls = pl.size(), rs = pr.size();
        if (ls == rs) {
            if (pr.isEmpty() || num <= pr.peek()) pl.add(num);
            else {
                pl.add(pr.poll());
                pr.add(num);
            }
        } else {
            if (num > pl.peek()) {
                pr.add(num);
            } else {
                pr.add(pl.poll());
                pl.add(num);
            }
        }
    }

    public double findMedian() {
        int ls = pl.size(), rs = pr.size();
        if (ls == rs) return ((pl.peek() + pr.peek()) / 2.0);
        else return pl.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */