/*
LeetCode 74 : Search a 2D Matrix

Question Link:
https://leetcode.com/problems/search-a-2d-matrix/

Topic: Binary Search, Matrix

Brute Force:

1. Traverse every element in the matrix.
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
LeetCode 74 : Search a 2D Matrix

Question Link:
https://leetcode.com/problems/search-a-2d-matrix/

Topic: Binary Search, Matrix

Optimal (Binary Search):

1. Treat the matrix as a sorted 1D array.
2. Apply Binary Search on indices [0, m*n-1].
3. Convert the 1D index into row and column:
      row = mid / n
      col = mid % n
4. Compare matrix[row][col] with target.
5. Return true if found, otherwise false.

Time Complexity: O(log(m * n))
Space Complexity: O(1)
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return false;
    }
}
