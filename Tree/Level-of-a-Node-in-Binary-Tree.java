/*
GeeksForGeeks : Level of a Node in Binary Tree

Question Link:
https://www.geeksforgeeks.org/problems/level-of-a-node-in-binary-tree/1

Topic: Binary Tree, Recursion

Approach:

1. The level of the root is 1.
2. If the current node is null, return 0.
3. If the current node contains the target,
   return 1.
4. Search for the target in the left subtree.
5. If found, add 1 to its level.
6. Otherwise, search in the right subtree.
7. If not found anywhere, return 0.

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of the tree.
*/

class Solution {

    int getLevel(Node node, int data) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Target found
        if (node.data == data) {
            return 1;
        }

        // Search in left subtree
        int left = getLevel(node.left, data);

        // Target found in left subtree
        if (left != 0) {
            return left + 1;
        }

        // Search in right subtree
        int right = getLevel(node.right, data);

        // Target found in right subtree
        if (right != 0) {
            return right + 1;
        }

        // Target not found
        return 0;
    }
}
