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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val>list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode res = list1;
        ListNode prev = null;
        while(list1!=null){
            while(list1!=null && list2!=null && list1.val<=list2.val){
                prev = list1;
                list1 = list1.next;
            }
            prev.next = list2;
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        if(list1!=null){
            prev.next = list1;
        }
        if(list2!=null){
            prev.next = list2;
        }
        return res;
    }
}