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
     static boolean hasNode(TreeNode root, int value) {
        if (root == null)
            return false;

        return root.val == value ||
               hasNode(root.left, value) ||
               hasNode(root.right, value);
    }

    static void findLca(TreeNode root, int n1, int n2,
                        TreeNode[] ans, int depth, int[] bestDepth) {
        if (root == null)
            return;

        // Check the current node as a potential LCA.
        if (hasNode(root, n1) && hasNode(root, n2)) {
            if (depth > bestDepth[0]) {
                bestDepth[0] = depth;
                ans[0] = root;
            }
        }

        // Continue checking every node as a potential LCA.
        findLca(root.left, n1, n2, ans, depth + 1, bestDepth);
        findLca(root.right, n1, n2, ans, depth + 1, bestDepth);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[1];
        int[] bestDepth = {-1};
        findLca(root, p.val,q.val, ans, 0 , bestDepth);
        return ans[0];
    }
}
