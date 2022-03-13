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
class Node {
    TreeNode treeNode;
    int x;
    int y;
    
    Node(TreeNode treeNode, int x, int y) {
        this.treeNode = treeNode;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entries = new TreeMap<>();
        bfs(root, entries);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> col : entries.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : col.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    
    private void bfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entries){
        if(root==null){
            return;
        }
        Queue<Node> level = new LinkedList<>();
        level.offer(new Node(root, 0, 0));
        while(!level.isEmpty()){
            Node node = level.poll();
            if(!entries.containsKey(node.x)){
                entries.put(node.x, new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            if(!entries.get(node.x).containsKey(node.y)){
                entries.get(node.x).put(node.y, new PriorityQueue<>());
            }
            entries.get(node.x).get(node.y).offer(node.treeNode.val);
            if(node.treeNode.left!=null){
                level.offer(new Node(node.treeNode.left, node.x-1, node.y+1));
            }
            if(node.treeNode.right!=null){
                level.offer(new Node(node.treeNode.right, node.x+1, node.y+1));
            }
        }
    }
}