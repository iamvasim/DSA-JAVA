/*
LeetCode 861 : Score After Flipping Matrix

Question Link:
https://leetcode.com/problems/score-after-flipping-matrix/

Topic: Greedy, Matrix

Optimal (Greedy):

1. Flip every row whose first element is 0,
   because the leftmost bit has the highest value.
2. For each remaining column (except the first),
   count the number of 0s.
3. If a column has more 0s than 1s,
   flip that column to maximize the number of 1s.
4. Treat each row as a binary number.
5. Compute the decimal value of every row and
   add them to obtain the maximum score.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/

class Solution {

    public int matrixScore(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Make the first column all 1s
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 0) {

                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Step 2: Flip columns if zeros are more than ones
        for (int j = 1; j < n; j++) {

            int countZero = 0;

            for (int i = 0; i < m; i++) {

                if (grid[i][j] == 0) {
                    countZero++;
                }
            }

            if (countZero > m - countZero) {

                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Step 3: Calculate the final score
        int score = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                score += grid[i][j] << (n - j - 1);
            }
        }

        return score;
    }
}
