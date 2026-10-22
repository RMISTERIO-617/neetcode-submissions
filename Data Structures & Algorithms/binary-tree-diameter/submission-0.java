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

class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;    
    }

    private int calculateHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int lheight = calculateHeight(node.left);
        int rheight = calculateHeight(node.right);

        diameter = Math.max(diameter, lheight + rheight);

        return 1 + Math.max(lheight, rheight);

    }
}
