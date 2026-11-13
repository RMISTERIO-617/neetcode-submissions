class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // Paso 1: Crear nodos clonados e intercalarlos (A -> A' -> B -> B')
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val); // Corregido: .val en vez de .data
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        // Paso 2: Asignar los punteros 'random' de los nodos clonados
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Paso 3: Separar la lista original de la lista clonada
        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;
        while (clone.next != null) {
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;
        
        return clonedHead;
    }
}