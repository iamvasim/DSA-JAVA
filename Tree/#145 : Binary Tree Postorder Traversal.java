/*
LeetCode 145 : Binary Tree Postorder Traversal

Question Link:
https://leetcode.com/problems/binary-tree-postorder-traversal/

Topic: Binary Tree, Recursion

Postorder Traversal:
Left → Right → Root

Approach:

1. If root is null, return.
2. Traverse the left subtree.
3. Traverse the right subtree.
4. Add the root value to the list.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        helper(root, list);

        return list;
    }

    void helper(TreeNode root, List<Integer> list) {

        // Base case
        if (root == null) {
            return;
        }

        // Left
        helper(root.left, list);

        // Right
        helper(root.right, list);

        // Root
        list.add(root.val);
    }
}
