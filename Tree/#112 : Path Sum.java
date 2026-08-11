/*
LeetCode 112 : Path Sum

Question Link:
https://leetcode.com/problems/path-sum/

Topic: Binary Tree, Recursion

Approach:

1. If root is null, no path exists.
2. If the current node is a leaf:
      - Check whether targetSum == root.val.
3. Otherwise, subtract root.val from targetSum.
4. Recursively check the left and right subtrees.
5. If either subtree contains a valid path, return true.

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of the tree.
*/

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Base case
        if (root == null) {
            return false;
        }

        // Check leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Check left or right subtree
        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }
}
