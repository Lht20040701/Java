package leetcode;

public class lec543 {
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
//    int ans = 0;
//    public int diameterOfBinaryTree(TreeNode root) {
//        dfs(root);
//        return ans - 1;
//    }
//
//    public int dfs(TreeNode root) {
//        if (root == null) return 0;
//        int x = dfs(root.left);
//        int y = dfs(root.right);
//        ans = Math.max(ans, x + y + 1);
//        return Math.max(x, y) + 1;
//    }
//}