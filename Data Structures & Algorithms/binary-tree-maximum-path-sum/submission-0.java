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
    public int maxPathSum(TreeNode root) {

        int[] maxSum = new int[]{root.val};

        dfs(root, maxSum);

        return maxSum[0];
    
    }

    public int dfs(TreeNode root, int[] maxSum){

        if(root == null) return 0;

        int leftMax = Math.max(dfs(root.left, maxSum), 0);
        int rightMax = Math.max(dfs(root.right, maxSum), 0);

        maxSum[0] = Math.max(maxSum[0], root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);

    }
}