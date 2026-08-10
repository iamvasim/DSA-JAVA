/*
GeeksForGeeks : Max and Min Element in Binary Tree

Question Link:
https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1

Topic: Binary Tree, Recursion

Approach:

1. If root is null:
      - For maximum, return Integer.MIN_VALUE.
      - For minimum, return Integer.MAX_VALUE.
2. Recursively find the maximum/minimum
   in the left subtree.
3. Recursively find the maximum/minimum
   in the right subtree.
4. Compare root.data with both results.
5. Return the final maximum/minimum.

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of the tree.
*/

class Solution {

    public static int findMax(Node root) {

        // Base case
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // Maximum in left subtree
        int leftMax = findMax(root.left);

        // Maximum in right subtree
        int rightMax = findMax(root.right);

        // Maximum among root, left and right
        return Math.max(root.data,
                Math.max(leftMax, rightMax));
    }

    public static int findMin(Node root) {

        // Base case
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Minimum in left subtree
        int leftMin = findMin(root.left);

        // Minimum in right subtree
        int rightMin = findMin(root.right);

        // Minimum among root, left and right
        return Math.min(root.data,
                Math.min(leftMin, rightMin));
    }
}
