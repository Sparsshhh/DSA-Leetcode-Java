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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;

        return countPath(root,targetSum)
            + pathSum(root.left,targetSum)
            +pathSum(root.right,targetSum);
    }
    public int countPath(TreeNode node, long remaining){
        if(node==null) return 0;
        int count=0;
        if(node.val==remaining) count++;
        count+=countPath(node.left,remaining-node.val);
        count+=countPath(node.right,remaining-node.val);

        return count;
    }
}

/*Treat every node as the starting point of a path.
Use one DFS (pathSum) to visit every node.
Use another DFS (countPaths) to count all downward paths starting from that node.
Add the counts from all starting nodes to get the final answer. */