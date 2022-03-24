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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diam = new int[1];
        traverse(root, diam);
        return diam[0];
    }
    
    private int traverse(TreeNode root, int[] diam) {
        if(root==null)
            return 0;
        int left = traverse(root.left, diam);
        int right = traverse(root.right, diam);
        diam[0] = Math.max(diam[0], left+right);
        return 1 + Math.max(left, right);
    }
}