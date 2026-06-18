/*
LeetCode 1283 : Find the Smallest Divisor Given a Threshold

Question Link:
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

Topic: Binary Search

Brute Force:

1. Find the maximum element in the array.
2. Try every divisor from 1 to maxElement.
3. Calculate the sum of ceil(nums[i] / divisor).
4. Return the first divisor for which
   sum <= threshold.

Time Complexity: O(n * maxElement)
Space Complexity: O(1)
*/

class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int divisor = 1; divisor <= max; divisor++) {

            int sum = 0;

            for (int num : nums) {

                sum += (num + divisor - 1) / divisor;
            }

            if (sum <= threshold) {
                return divisor;
            }
        }

        return -1;
    }
}



/*
LeetCode 1283 : Find the Smallest Divisor Given a Threshold

Question Link:
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

Topic: Binary Search

Optimal (Binary Search on Answer):

1. Minimum divisor can be 1.
2. Maximum divisor can be the largest element.
3. For a given divisor, calculate:
      sum = ceil(nums[i] / divisor)
4. If sum <= threshold,
   try a smaller divisor.
5. Otherwise, increase the divisor.
6. The first valid divisor is the answer.

Time Complexity: O(n * log(maxElement))
Space Complexity: O(1)
*/

class Solution {

    boolean isPossible(int[] nums,
                       int divisor,
                       int threshold) {

        int sum = 0;

        for (int num : nums) {

            sum += (num + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int low = 1;
        int high = max;

        int ans = max;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, threshold)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}
