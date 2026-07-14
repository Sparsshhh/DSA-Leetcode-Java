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
    HashMap<Long, Integer> prefixMap = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        prefixMap.put(0L, 1);

        return dfs(root, 0L, targetSum);
    }

    public int dfs(TreeNode node, long currSum, int target) {
        if (node == null)
            return 0;

        currSum += node.val;

        int count = prefixMap.getOrDefault(currSum - target, 0);

        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, target);
        count += dfs(node.right, currSum, target);

        prefixMap.put(currSum,prefixMap.get(currSum) - 1);

        return count;
    }
}