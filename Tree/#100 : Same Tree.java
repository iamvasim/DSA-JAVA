/*
LeetCode 100 : Same Tree

Topic: Binary Tree, Recursion

Approach:

1. If both nodes are null, both trees are same.
2. If one node is null, trees are different.
3. If values are different, trees are different.
4. Recursively compare:
      - left subtree
      - right subtree
5. Both must be same.

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
