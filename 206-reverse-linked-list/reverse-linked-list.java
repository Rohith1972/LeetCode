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
        Stack<Integer> st = new Stack<>();
        ListNode p = head;
        while(p != null){
            st.push(p.val);
            p = p.next;
        }
        ListNode t = head;
        while(t != null){
            t.val = st.pop();
            t = t.next;
        }
        return head;
    }
}