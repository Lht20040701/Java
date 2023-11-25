package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//public class lec160 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int x = 0, y = 0;
//        ListNode ans = null;
//        ListNode pointerA = headA, pointerB = headB;
//        for (; pointerA != null; pointerA = pointerA.next) x ++ ;
//        for (; pointerB != null; pointerB = pointerB.next) y ++ ;
//
//        pointerA = headA; pointerB = headB;
//        while (x > y) {pointerA = pointerA.next; x -- ;}
//        while (y > x) {pointerB = pointerB.next; y -- ;}
//
//        while (x > 0) {
//            if (pointerA == pointerB) {
//                ans = pointerA;
//                break;
//            }
//            pointerA = pointerA.next;
//            pointerB = pointerB.next;
//            x -- ;
//        }
//        return ans;
//    }
//}
