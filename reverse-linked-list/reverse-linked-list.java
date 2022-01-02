/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        ListNode rev = reverseList(head.next);
        head.next = null;
        addToLast(rev, head);
        return rev;
    }
    
    private void addToLast(ListNode rev, ListNode head){
        while(rev.next!=null){
            rev = rev.next;
        }
        rev.next = head;
    }
}