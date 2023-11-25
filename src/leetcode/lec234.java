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
//public class lec234 {
//    public boolean isPalindrome(ListNode head) {
//        ListNode firsthalf = findHalf(head); // 找到链表的一半
//        ListNode secondhalf = reverseList(firsthalf.next); // 反转后半段
//
//        // 开始判断
//        firsthalf = head;
//        while (secondhalf != null) {
//            if (firsthalf.val != secondhalf.val) return false;
//            firsthalf = firsthalf.next;
//            secondhalf = secondhalf.next;
//        }
//        return true;
//    }
//
//    // 反转链表方法
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null, curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }
//
//    // 利用快慢指针找到链表的一半
//    public ListNode findHalf(ListNode head) {
//        ListNode slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//}