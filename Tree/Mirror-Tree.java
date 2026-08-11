/*
GeeksForGeeks : Mirror Tree

Question Link:
https://www.geeksforgeeks.org/problems/mirror-tree/1

Topic: Binary Tree, Recursion

Approach:

1. If root is null, return.
2. Swap the left and right child of the current node.
3. Recursively mirror the left subtree.
4. Recursively mirror the right subtree.
5. Since we modify the existing nodes, no new tree is created.

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of the tree.
*/

class Solution {

    void mirror(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Swap left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Mirror left subtree
        mirror(root.left);

        // Mirror right subtree
        mirror(root.right);
    }
}
