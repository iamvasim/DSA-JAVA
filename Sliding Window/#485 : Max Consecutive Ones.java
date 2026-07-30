/*
LeetCode 485 : Max Consecutive Ones

Question Link:
https://leetcode.com/problems/max-consecutive-ones/

Topic: Arrays

Optimal (Linear Traversal):

1. Traverse the array from left to right.
2. Maintain a counter for the current consecutive
   sequence of 1s.
3. If the current element is 1:
      - Increment the counter.
      - Update the maximum count.
4. If the current element is 0:
      - Reset the counter to 0.
5. Return the maximum consecutive count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int n = nums.length;

        int maxLen = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 1) {

                count++;
                maxLen = Math.max(maxLen, count);

            } else {

                count = 0;
            }
        }

        return maxLen;
    }
}

/*
LeetCode 485 : Max Consecutive Ones

Question Link:
https://leetcode.com/problems/max-consecutive-ones/

Topic: Arrays, Sliding Window

Optimal (Sliding Window):

1. Maintain two pointers:
      - start: beginning of the current window.
      - end: end of the current window.
2. Expand the window by moving the end pointer.
3. Whenever a 0 is encountered, move the start
   pointer to end + 1 since a valid window can
   only contain consecutive 1s.
4. Update the maximum window length after every
   iteration.
5. Return the maximum length obtained.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int n = nums.length;

        int len = 0;
        int start = 0;

        // Expand the window
        for (int end = 0; end < n; end++) {

            // Reset the window when a 0 is found
            if (nums[end] == 0) {
                start = end + 1;
            }

            // Update the maximum window length
            len = Math.max(len, end - start + 1);
        }

        return len;
    }
}
