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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode next = head;
        while(n-- > 0){
            next = next.next;
        }
        if(next==null){
            return head.next;
        }
        while(next.next!=null){
            next = next.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}