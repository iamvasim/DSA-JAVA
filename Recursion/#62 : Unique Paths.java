/*
LeetCode 62 : Unique Paths

Question Link:
https://leetcode.com/problems/unique-paths/

Topic: Recursion

Brute Force (Recursion):

1. If only one row or one column remains,
   there is only one path.
2. Otherwise:
      Total Paths =
      Paths from Top +
      Paths from Left
3. Recursively calculate both possibilities.

Time Complexity: O(2^(m+n))
Space Complexity: O(m+n)
*/

class Solution {

    public int uniquePaths(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePaths(m - 1, n)
             + uniquePaths(m, n - 1);
    }
}
