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
    int maxLength = 0;

    void solve(TreeNode root, int dir, int currLength) {
        if (root == null)
            return;
        maxLength = Math.max(maxLength, currLength);
        solve(root.left, 0, dir == 1 ? currLength + 1 : 1);
        solve(root.right, 1, dir == 0 ? currLength + 1 : 1);
    }

    public int longestZigZag(TreeNode root) {
        solve(root, 0, 0);
        solve(root, 1, 0);
        return maxLength;

    }
}