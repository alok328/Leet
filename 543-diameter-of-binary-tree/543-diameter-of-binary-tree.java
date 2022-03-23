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
    int maxDiam = 0;
    private int findHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return 1 + Math.max(left, right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        int diameter = left + right;
        maxDiam = Math.max(diameter, maxDiam);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxDiam;
    }
}