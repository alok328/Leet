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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = findLen(head);
        int groups = len/k;
        ListNode res = new ListNode();
        res.next = head;
        ListNode prev = res;
        for(int i=0; i<groups; i++){
            ListNode cur = prev.next;
            ListNode next = cur.next;
            for(int j=1; j<k; j++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
        }
        return res.next;
    }
    
    private int findLen(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
}