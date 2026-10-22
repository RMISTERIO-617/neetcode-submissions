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
        int len = 0;
        ListNode cur = head;

        while(cur != null){
            len++;
            cur = cur.next;
        }
        if (len == n){
            return head.next;
        }
        
        cur = head;

        for(int i = 1; i < len -n; i++){
            cur = cur.next;
        }
            
        cur.next = cur.next.next;
        return head;
    }
}
