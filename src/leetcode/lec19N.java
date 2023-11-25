package leetcode;

public class lec19N {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0, head); // 放置一下假人, 作为头节点
//        ListNode fr = head, se = dummy;
//        for (int i = 0; i < n; i ++ ) fr = fr.next;
//        while (fr != null) {
//            fr = fr.next;
//            se = se.next;
//        }
//        se.next = se.next.next;
//        return dummy.next;
//    }
//}