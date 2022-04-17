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
class Pair {
    TreeNode node;
    int index;   
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {    
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int width = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int left = 0;
            int right = 0;
            int min = queue.peek().index;
            for(int i=0; i<size; i++){
                int idx = queue.peek().index-min;
                TreeNode node = queue.poll().node;
                if(i==0){
                    left = idx;
                }
                if(i==size-1){
                    right = idx;
                }
                if(node.left!=null) {
                    queue.offer(new Pair(node.left, idx*2+1));
                }
                if(node.right!=null) {
                    queue.offer(new Pair(node.right, idx*2+2));
                }
            }
            width = Math.max(width, right-left+1);
        }
        return width;
    }
}