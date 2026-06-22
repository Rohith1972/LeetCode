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
        if(head.next == null && n==1){
            head = null;
            return head;
        }
        ListNode p = head;
        int count = 0;
        while(p!=null){
            count++;
            p = p.next;
        }
        int newN = count-n;
        if(newN == 0){
            head = head.next;
            return head;
        }
        ListNode t = head;
        ListNode x = null;
        for(int i=0;i<newN;i++){
            x = t;
            t = t.next;
        }
        if(t.next!=null){
            x.next = t.next;
            return head;
        }
        x.next = null;
        return head;
    }
}