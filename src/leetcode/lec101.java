package leetcode;

public class lec101 {
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
//    public boolean isSymmetric(TreeNode root) {
//        if (root.left == null && root.right != null || root.left != null && root.right == null) return false;
//        if (root.left == null && root.right == null) return true;
//
//        return dfs(root.left, root.right);
//    }
//
//    public boolean dfs(TreeNode l, TreeNode r) {
//        if (l == null && r == null) return true;
//        if (l == null && r != null) return false;
//        if (l != null && r == null) return false;
//        return l.val == r.val && dfs(l.right, r.left) && dfs(l.left, r.right);
//    }
//}