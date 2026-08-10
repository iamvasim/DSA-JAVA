/*
LeetCode 101 : Symmetric Tree

Question Link:
https://leetcode.com/problems/symmetric-tree/

Topic: Binary Tree, Recursion

Approach:

1. Compare the left and right subtrees.
2. If both nodes are null, they are symmetric.
3. If only one node is null, they are not symmetric.
4. If their values are different, return false.
5. Compare:
      - left.left  with right.right
      - left.right with right.left
6. If both comparisons are true, the tree is symmetric.

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of the tree.
*/

class Solution {

    // Check whether two trees are mirror images
    public boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // One node is null
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite sides
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }
}
