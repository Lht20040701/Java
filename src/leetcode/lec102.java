package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lec102 {
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
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if (root == null) return ans;
//        Queue<TreeNode> q = new LinkedList<>();
//        int rowNow = 1, rowNext = 0;
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            List<Integer> row = new ArrayList<>();
//            while (rowNow -- > 0 ) {
//                TreeNode t = q.poll();
//                row.add(t.val);
//                if (t.left != null) {
//                    q.add(t.left);
//                    rowNext ++ ;
//                }
//                if (t.right != null) {
//                    q.add(t.right);
//                    rowNext ++ ;
//                }
//            }
//            ans.add(row);
//            rowNow = rowNext;
//            rowNext = 0;
//        }
//        return ans;
//    }
//}