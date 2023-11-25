package leetcode;

public class lec108 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//class Solution {
//    public TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode root = null;
//        root = buildBST(nums, 0, nums.length - 1);
////        System.out.println(root);
//        return root;
//    }
//
//    public TreeNode buildBST(int[] nums, int left, int right) {
//        if (left > right) return null;
//        int mid = left + right >> 1;
//        TreeNode root = new TreeNode(nums[mid]);
////        System.out.println(root.val);
//        root.left = buildBST(nums, left, mid - 1);
//        root.right = buildBST(nums, mid + 1, right);
//        return root;
//    }
//}