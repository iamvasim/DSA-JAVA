/*
LeetCode 713 : Subarray Product Less Than K

Question Link:
https://leetcode.com/problems/subarray-product-less-than-k/

Topic: Arrays, Sliding Window, Two Pointers

Optimal (Sliding Window):

1. If k <= 1, return 0 because no positive product
   can be strictly less than k.
2. Maintain a sliding window with two pointers:
      - start: left boundary.
      - end: right boundary.
3. Expand the window by multiplying the current
   element with the product.
4. While the product becomes greater than or equal
   to k, shrink the window from the left by
   dividing out the leftmost element.
5. After the window becomes valid, all subarrays
   ending at the current index are valid.
6. Add the current window length
   (end - start + 1) to the answer.
7. Return the total count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int n = nums.length;

        // No valid subarray exists
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int start = 0;

        // Expand the window
        for (int end = 0; end < n; end++) {

            product *= nums[end];

            // Shrink the window until product < k
            while (product >= k) {

                product /= nums[start];
                start++;
            }

            // Count all valid subarrays ending at 'end'
            count += (end - start + 1);
        }

        return count;
    }
}
