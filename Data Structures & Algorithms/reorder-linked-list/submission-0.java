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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }

        //Encontrar la mitad
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }

        //Parte 2: Reversa la segunda mitad 
        ListNode previous = null;
        ListNode current = slow;
        ListNode next = null;

        while(current != null){ 
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        //Parte 3: Se emergen ambas mitades
        ListNode first = head;
        ListNode second = previous;

        while(second.next != null){
            //Guarde los siguientes nodos para no perder el resto del lista
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            //Conectar first con second a temp1
            first.next = second;
            second.next = temp1;
            //Avanzar nuestros dedos a los nodos que guardamos
            first = temp1;
            second = temp2;
        }
    }
}
