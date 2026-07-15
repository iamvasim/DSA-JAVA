/*
TUF : Check if There Exists a Subsequence with Sum K

Question Link:
https://takeuforward.org/plus/dsa/problems/check-if-there-exists-a-subsequence-with-sum-k

Topic: Recursion, Backtracking

Optimal (Backtracking):

1. At every index, choose:
      - Include the current element.
      - Exclude the current element.
2. Maintain the current sum during recursion.
3. When all elements are processed,
   check whether the current sum equals k.
4. If any recursive call returns true,
   immediately return true.
5. Otherwise return false.

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

class Solution {

    boolean solve(int[] nums,
                  int k,
                  int i,
                  int n,
                  int currSum) {

        if (i == n) {
            return currSum == k;
        }

        // Include current element OR Exclude current element
        return solve(nums, k, i + 1, n, currSum + nums[i]) ||
               solve(nums, k, i + 1, n, currSum);
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {

        return solve(nums, k, 0, nums.length, 0);
    }
}
