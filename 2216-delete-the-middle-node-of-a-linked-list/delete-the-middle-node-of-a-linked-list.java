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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        ListNode fp = head;
        ListNode sp = head;
        while(fp != null && fp.next != null){
            fp = (fp.next).next;
            sp = sp.next;
        }
        ListNode p = head;
        while(p.next!=sp)
            p = p.next;
        p.next = sp.next;
        System.gc();
        return head;
    }
}