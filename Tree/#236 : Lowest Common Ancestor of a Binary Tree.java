/*
LeetCode 236 : Lowest Common Ancestor of a Binary Tree

Question Link:
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Topic: Binary Tree, Recursion

Approach:

1. If the current node is null, return null.
2. If the current node is either p or q, return the current node.
3. Recursively search for p and q in the left and right subtrees.
4. If both left and right return a node, p and q are found
   in different subtrees, so the current node is the LCA.
5. If only one side returns a node, return that node.
6. If both sides are null, return null.

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null) {
            return null;
        }

        // If current node is p or q
        if (root == p || root == q) {
            return root;
        }

        // Search in left subtree
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        // p and q found in different subtrees
        if (leftN != null && rightN != null) {
            return root;
        }

        // If found in left subtree
        if (leftN != null) {
            return leftN;
        }

        // Otherwise return result from right subtree
        return rightN;
    }
}
