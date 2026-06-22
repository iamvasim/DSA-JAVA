/*
Find Row with Maximum 1's

Question Link:
https://takeuforward.org/plus/dsa/problems/find-row-with-maximum-1's

Topic: Binary Search, Matrix

Brute Force:

1. Count the number of 1's in every row.
2. Keep track of the row having maximum 1's.
3. If no 1 exists in the matrix, return -1.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class Solution {

    public int rowWithMax1s(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int maxCount = 0;
        int ans = -1;

        for (int i = 0; i < rows; i++) {

            int count = 0;

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxCount) {

                maxCount = count;
                ans = i;
            }
        }

        return ans;
    }
}


/*
Find Row with Maximum 1's

Question Link:
https://takeuforward.org/plus/dsa/problems/find-row-with-maximum-1's

Topic: Binary Search, Matrix

Better:

1. Since each row is sorted,
   find the first occurrence of 1 using Binary Search.
2. Number of ones = cols - firstOneIndex.
3. Track the row with maximum ones.

Time Complexity: O(m * log n)
Space Complexity: O(1)
*/

class Solution {

    public int rowWithMax1s(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int maxCount = 0;
        int ans = -1;

        for (int i = 0; i < rows; i++) {

            int low = 0;
            int high = cols - 1;

            int firstOne = cols;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (mat[i][mid] == 1) {

                    firstOne = mid;
                    high = mid - 1;

                } else {

                    low = mid + 1;
                }
            }

            int ones = cols - firstOne;

            if (ones > maxCount) {

                maxCount = ones;
                ans = i;
            }
        }

        return ans;
    }
}


/*
Find Row with Maximum 1's

Question Link:
https://takeuforward.org/plus/dsa/problems/find-row-with-maximum-1's

Topic: Binary Search, Matrix

Optimal:

1. Start from the top-right corner.
2. If current cell is 1:
      move left and update answer.
3. If current cell is 0:
      move down.
4. Each row or column is processed at most once.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class Solution {

    public int rowWithMax1s(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int col = cols - 1;

        int ans = -1;

        for (int row = 0; row < rows; row++) {

            while (col >= 0 && mat[row][col] == 1) {

                ans = row;
                col--;
            }
        }

        return ans;
    }
}
