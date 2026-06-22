/*
LeetCode 240 : Search a 2D Matrix II

Question Link:
https://leetcode.com/problems/search-a-2d-matrix-ii/

Topic: Binary Search, Matrix

Brute Force:

1. Traverse every element of the matrix.
2. If target is found, return true.
3. Otherwise return false.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}



/*
LeetCode 240 : Search a 2D Matrix II

Question Link:
https://leetcode.com/problems/search-a-2d-matrix-ii/

Topic: Binary Search, Matrix

Better:

1. Every row is sorted.
2. Apply Binary Search on each row.
3. If target is found in any row, return true.

Time Complexity: O(m * log n)
Space Complexity: O(1)
*/

class Solution {

    boolean binarySearch(int[] row, int target) {

        int low = 0;
        int high = row.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (row[mid] == target) {
                return true;
            }

            if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int[] row : matrix) {

            if (binarySearch(row, target)) {
                return true;
            }
        }

        return false;
    }
}



/*
LeetCode 240 : Search a 2D Matrix II

Question Link:
https://leetcode.com/problems/search-a-2d-matrix-ii/

Topic: Matrix, Binary Search

Optimal (Staircase Search):

1. Start from the top-right corner.
2. If current value equals target, return true.
3. If current value is greater than target,
   move left.
4. If current value is smaller than target,
   move down.
5. Continue until indices go out of bounds.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            int value = matrix[row][col];

            if (value == target) {
                return true;
            }

            if (value > target) {

                col--;

            } else {

                row++;
            }
        }

        return false;
    }
}
