package leetcode;

public class lec2 {
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
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode l3 = new ListNode();
//        ListNode p3 = l3;
//        boolean f = false;
//        while (l1 != null && l2 != null) {
//            int x = l1.val, y = l2.val;
//            l1 = l1.next; l2 = l2.next;
//            int w = x + y;
//            if (f) {
//                w ++ ;
//                f = false;
//            }
//
//            if (w >= 10) {
//                f = true;
//                w %= 10;
//            }
//
//            p3.val = w;
//            if (l1 != null || l2 != null) {
//                p3.next = new ListNode();
//                p3 = p3.next;
//            }
//        }
//
//        while (l1 != null) {
//            int x = l1.val;
//            l1 = l1.next;
//            if (f) {
//                x ++ ;
//                f = false;
//            }
//
//            if (x >= 10) {
//                f = true;
//                x %= 10;
//            }
//
//            p3.val = x;
//            if (l1 != null) {
//                p3.next = new ListNode();
//                p3 = p3.next;
//            }
//        }
//
//        while (l2 != null) {
//            int x = l2.val;
//            l2 = l2.next;
//            if (f) {
//                x ++ ;
//                f = false;
//            }
//
//            if (x >= 10) {
//                f = true;
//                x %= 10;
//            }
//
//            p3.val = x;
//            if (l2 != null) {
//                p3.next = new ListNode();
//                p3 = p3.next;
//            }
//        }
//
//        if (f) {
//            p3.next = new ListNode();
//            p3 = p3.next;
//            p3.val = 1;
//        }
//        p3.next = null;
//        return l3;
//    }
//}
