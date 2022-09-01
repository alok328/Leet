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
    public int goodNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int[] ans = {0};
        traverse(root, root.val, ans);
        return ans[0];
    }
    
    private void traverse(TreeNode node, int max, int[] ans) {
        if(node==null){
            return;
        }
        // System.out.println(node.val + " " + max + " " + ans[0]);
        traverse(node.left, node.val>max ? node.val : max, ans);
        if(node.val>=max) {
            ans[0]++;
        }
        traverse(node.right, node.val>max ? node.val : max, ans);
    }
}