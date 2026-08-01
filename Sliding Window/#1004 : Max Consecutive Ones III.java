/*
LeetCode 1004 : Max Consecutive Ones III

Question Link:
https://leetcode.com/problems/max-consecutive-ones-iii/

Topic: Arrays, Sliding Window, Two Pointers

Optimal (Sliding Window):

1. Maintain a sliding window using two pointers:
      - left: left boundary.
      - right: right boundary.
2. Count the number of zeros in the current window.
3. Expand the window by moving the right pointer.
4. If the number of zeros exceeds k,
   shrink the window from the left until
   the window becomes valid again.
5. Update the maximum window length after
   each valid expansion.
6. Return the maximum length obtained.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int maxLen = 0;
        int countZero = 0;

        // Expand the window
        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                countZero++;
            }

            // Shrink the window if zeros exceed k
            while (countZero > k) {

                if (nums[left] == 0) {
                    countZero--;
                }

                left++;
            }

            // Update the maximum valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
