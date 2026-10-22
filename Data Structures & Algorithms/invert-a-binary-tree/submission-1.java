/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Definición del nodo (LeetCode te la da por defecto)
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 1. Caso Base: Si llegamos a un nodo vacío (hoja)
        if (root == null) {
            return null;
        }
        
        // 2. Intercambio (Swap) usando una variable temporal
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // 3. Llamada recursiva para invertir los sub-árboles
        invertTree(root.left);
        invertTree(root.right);
        
        // 4. Retornar el nodo raíz ya invertido
        return root;
    }
}