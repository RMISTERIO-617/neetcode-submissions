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
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Guardamos el resto de la lista
            curr.next = prev;              // Invertimos la conexión hacia atrás
            
            prev = curr;                   // Avanzamos 'prev'
            curr = nextTemp;               // Avanzamos 'curr'
        }

        return prev;
    }
}