/*
LeetCode 199 : Binary Tree Right Side View

Question Link:
https://leetcode.com/problems/binary-tree-right-side-view/

Topic: Binary Tree, DFS, Recursion

Approach:

1. Perform DFS traversal starting from the root.
2. Visit the right subtree before the left subtree.
3. For each level, add the first node we encounter.
4. Since the right subtree is visited first, the first node
   at each level is the rightmost visible node.
5. Store these nodes in the answer list.

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {

    // DFS traversal function
    static void preOrder(TreeNode root, int level, List<Integer> ans) {

        // Base case
        if (root == null) {
            return;
        }

        // If this is the first node visited at this level,
        // add it to the answer
        if (ans.size() < level) {
            ans.add(root.val);
        }

        // Visit RIGHT subtree first
        preOrder(root.right, level + 1, ans);

        // Then visit LEFT subtree
        preOrder(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {

        // Stores final right side view
        List<Integer> ans = new ArrayList<>();

        // Start DFS from root
        // Level starts from 1
        preOrder(root, 1, ans);

        return ans;
    }
}
