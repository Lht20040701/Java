package leetcode;

public class lec104 {
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
//    public int maxDepth(TreeNode root) {
//        return dfs(root, 0);
//    }
//
//    public int dfs(TreeNode root, int dep) {
//        if (root == null) return dep;
//        return Math.max(dfs(root.left, dep) + 1, dfs(root.right, dep) + 1);
//    }
//}