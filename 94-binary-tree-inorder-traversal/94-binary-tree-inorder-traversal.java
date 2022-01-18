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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverseIterative(root, ans);
        return ans;
    }
    
    private void traverseIterative(TreeNode root, List<Integer> ans){
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();
        while(cur!=null || !s.isEmpty()){
            while(cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            TreeNode n = s.pop();
            ans.add(n.val);
            cur = n.right;
        }
    }
}