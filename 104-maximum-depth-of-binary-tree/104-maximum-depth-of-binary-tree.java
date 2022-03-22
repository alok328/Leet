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
class Solution {
    int depth = 0;
    private void updateDepth(TreeNode root, int height){
        if(root==null){
            depth = Math.max(depth, height);
            return;
        }
        updateDepth(root.left, height+1);
        updateDepth(root.right, height+1);
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return depth;
        }
        updateDepth(root, 0);
        return depth;
    }
}