/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Map<Node, Node> corNodes = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            corNodes.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            Node clone = corNodes.get(temp);
            clone.next = corNodes.get(temp.next);
            clone.random = corNodes.get(temp.random);
            temp = temp.next;
        }
        return corNodes.get(head);
    }
}