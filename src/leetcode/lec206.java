package leetcode;

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
//public class lec206 {
//    public ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        ListNode h = head;
//        head = head.next;
//        h.next = null;
//        while (head != null) {
//            ListNode t = head;
//            head = head.next;
//            t.next = h;
//            h = t;
//        }
//
//        return h;
//    }
//}

//public class lec206 {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null, cur = head;
//        while (cur != null) {
//            ListNode nextTemp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nextTemp;
//        }
//        return prev;
//    }
//}
//
