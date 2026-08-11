/*
LeetCode 102 : Binary Tree Level Order Traversal

Question Link:
https://leetcode.com/problems/binary-tree-level-order-traversal/

Topic: Binary Tree, BFS, Queue

Approach:

1. If root is null, return an empty list.
2. Use a Queue for BFS traversal.
3. Add the root to the queue.
4. For every level:
      - Store the current queue size.
      - Remove exactly that many nodes.
      - Add their values to the current level.
      - Add their left and right children to the queue.
5. Add the current level to the answer.
6. Return the answer.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // Empty tree
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            // Store nodes of current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.remove();

                level.add(node.val);

                // Add left child
                if (node.left != null) {
                    q.add(node.left);
                }

                // Add right child
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ans.add(level);
        }

        return ans;
    }
}
