/*
LeetCode 1343 : Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

Question Link:
https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

Topic: Arrays, Sliding Window

Optimal (Sliding Window):

1. Calculate the sum of the first window of size k.
2. If the average of the first window is greater than
   or equal to the threshold, increment the count.
3. Slide the window one element at a time:
      - Remove the leftmost element.
      - Add the next element.
4. After each slide, check whether the window's
   average is at least the threshold.
5. Return the total count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int index = 0;
        int n = arr.length;
        int count = 0;

        // Calculate the sum of the first window
        while (index < k) {

            sum += arr[index];
            index++;
        }

        if (sum >= threshold * k) {
            count++;
        }

        // Slide the window
        for (int i = 1; i <= n - k; i++) {

            int prev = arr[i - 1];
            int next = arr[i + k - 1];

            sum = sum - prev + next;

            if (sum >= threshold * k) {
                count++;
            }
        }

        return count;
    }
}
