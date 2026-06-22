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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode t = l2;
        ListNode head = null;
        int carry = 0; 
        while(p!=null || t!=null){
            int sum = 0;
            if(p!=null){
                sum += p.val;
                p = p.next;
            }
            if(t!=null){
                sum += t.val;
                t = t.next;
            }
            sum += carry;
            carry = sum/10;
            ListNode n = new ListNode(sum%10);
            if(head == null){
                head = n;
            }else{
                ListNode x = head;
                while(x.next!=null){
                    x = x.next;
                }
                x.next = n;
            }
        }
        if(carry != 0){
            ListNode n1 = new ListNode(carry);
            ListNode y = head;
            while(y.next!=null){
                y = y.next;
            }
            y.next = n1;
        }
        return head;
    }
}