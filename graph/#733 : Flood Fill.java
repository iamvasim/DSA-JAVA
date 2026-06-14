/*
LeetCode 733 : Flood Fill

Question Link:
https://leetcode.com/problems/flood-fill/

Topic: Graphs, DFS

Optimal (DFS):

1. Store the original color.
2. Start DFS from (sr, sc).
3. Change the current pixel to the new color.
4. Visit all 4-directionally connected pixels having the same original color.
5. Continue until all connected pixels are filled.

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/

class Solution {

    void dfs(int[][] image,
             int row,
             int col,
             int newColor,
             int originalColor) {

        if (row < 0 || col < 0
                || row >= image.length
                || col >= image[0].length
                || image[row][col] != originalColor
                || image[row][col] == newColor) {

            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, newColor, originalColor); // Up
        dfs(image, row + 1, col, newColor, originalColor); // Down
        dfs(image, row, col - 1, newColor, originalColor); // Left
        dfs(image, row, col + 1, newColor, originalColor); // Right
    }

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }
}
