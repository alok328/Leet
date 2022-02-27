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
    private void traverseInorder(TreeNode root, List<Integer> inorder){
        if(root==null){
            return;
        }
        traverseInorder(root.left, inorder);
        inorder.add(root.val);
        traverseInorder(root.right, inorder);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        traverseInorder(root, inorder);
        return inorder;
    }
}