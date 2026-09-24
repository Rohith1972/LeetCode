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
        ListNode dummy = new ListNode(-1);
        ListNode left = list1;
        ListNode right = list2;
        ListNode t = dummy;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                t.next = left;
                left = left.next;
                t = t.next;
                t.next = null;
            }else{
                t.next = right;
                right = right.next;
                t = t.next;
                t.next = null;
            }
        }
        while(left!=null){
            t.next = left;
            left = left.next;
            t = t.next;
            t.next = null;
        }
        while(right!=null){
            t.next = right;
            right = right.next;
            t = t.next;
            t.next = null;
        }
        return dummy.next;
    }
}