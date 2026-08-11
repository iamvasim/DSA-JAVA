/*
LeetCode 110 : Balanced Binary Tree

Question Link:
https://leetcode.com/problems/balanced-binary-tree/

Topic: Binary Tree, Recursion

Approach:

1. Find the height of the left and right subtrees.
2. If their difference is greater than 1,
   the tree is not balanced.
3. Recursively check the left and right subtrees.

Time Complexity: O(n²)
Space Complexity: O(h)
*/

class Solution {

    int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH - rightH) > 1) {
            return false;
        }

        return isBalanced(root.left) &&
               isBalanced(root.right);
    }
}
