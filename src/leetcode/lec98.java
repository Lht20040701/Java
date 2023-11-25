package leetcode;

public class lec98 {
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
//    public boolean isValidBST(TreeNode root) {
//        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean dfs(TreeNode t, long low, long hig) {
//        if (t == null) return true;
//        if (t.val <= low || t.val >= hig) return false;
//        return dfs(t.left, low, t.val) && dfs(t.right, t.val, hig);
//    }
//}