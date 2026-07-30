/*
LeetCode 643 : Maximum Average Subarray I

Question Link:
https://leetcode.com/problems/maximum-average-subarray-i/

Topic: Arrays, Sliding Window

Optimal (Sliding Window):

1. Calculate the sum of the first k elements.
2. Store it as the maximum sum.
3. Slide the window one element at a time:
      - Remove the leftmost element.
      - Add the next element.
4. Update the maximum sum after each slide.
5. Return the maximum sum divided by k.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        double sum = 0;

        int index = 0;

        // Calculate the sum of the first window
        while (index < k) {
            sum += nums[index++];
        }

        double maxSum = sum;

        // Slide the window
        for (int i = 1; i <= n - k; i++) {

            int prev = nums[i - 1];
            int next = nums[i + k - 1];

            sum = sum - prev + next;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }
}
