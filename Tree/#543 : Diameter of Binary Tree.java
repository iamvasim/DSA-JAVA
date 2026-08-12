/*
LeetCode 543 : Diameter of Binary Tree

Question Link:
https://leetcode.com/problems/diameter-of-binary-tree/

Topic: Binary Tree, Recursion

Approach:

1. Find the height of the left and right subtrees.
2. The diameter passing through the current node is
   left height + right height.
3. Update the maximum diameter found so far.
4. Return the height of the current node.
5. Repeat this process recursively for every node.

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {

    // Stores the maximum diameter found
    int result = 0;

    int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Find height of left subtree
        int left = solve(root.left);

        // Find height of right subtree
        int right = solve(root.right);

        // Diameter passing through current node
        result = Math.max(result, left + right);

        // Return height of current node
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        solve(root);

        return result;
    }
}
