/*
LeetCode 209 : Minimum Size Subarray Sum

Question Link:
https://leetcode.com/problems/minimum-size-subarray-sum/

Topic: Arrays, Sliding Window, Two Pointers

Optimal (Sliding Window):

1. Initialize two pointers (start and end) and a
   variable to store the current window sum.
2. Expand the window by moving the end pointer and
   add the current element to the sum.
3. While the window sum is greater than or equal to
   the target:
      - Update the minimum window length.
      - Shrink the window from the left by removing
        the leftmost element from the sum.
4. Continue until all elements are processed.
5. If no valid subarray exists, return 0;
   otherwise, return the minimum length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Expand the window
        for (int end = 0; end < n; end++) {

            sum += nums[end];

            // Shrink the window while sum satisfies the condition
            while (sum >= target) {

                minLen = Math.min(minLen, end - start + 1);

                sum -= nums[start];
                start++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
