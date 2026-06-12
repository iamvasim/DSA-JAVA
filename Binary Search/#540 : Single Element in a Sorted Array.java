/*
540. Single Element in a Sorted Array

Better (XOR):

All duplicate elements cancel each other out
because:

a ^ a = 0
0 ^ b = b

The remaining value is the single element.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int singleNonDuplicate(int[] nums) {

        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}

/*
540. Single Element in a Sorted Array

Optimal (Binary Search):

Before the single element:
Pairs start at even indices.

After the single element:
Pairs start at odd indices.

Use Binary Search to find where this pattern breaks.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {

                // Single element lies on the right
                left = mid + 2;

            } else {

                // Single element lies on the left
                right = mid;
            }
        }

        return nums[left];
    }
}
