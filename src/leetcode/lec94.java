package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec94 {
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
//    List<Integer> ans = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        tranverse(root);
//        return ans;
//    }
//
//    public void tranverse(TreeNode root){
//        if (root == null) {
//            return ;
//        }
//
//        tranverse(root.left);
//        ans.add(root.val);
//        tranverse(root.right);
//    }
//}