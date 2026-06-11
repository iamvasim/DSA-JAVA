/*
153. Find Minimum in Rotated Sorted Array

Brute Force:
Traverse the entire array and keep track of the minimum element.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        return min;
    }
}


/*
153. Find Minimum in Rotated Sorted Array

Optimal (Binary Search):

At least one half of the array is always sorted.

1. If the current range is already sorted,
   nums[low] is the minimum.
2. If the left half is sorted,
   the minimum must be in the right half.
3. Otherwise, the minimum lies in the left half.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Entire range is sorted
            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                min = Math.min(min, nums[low]);
                low = mid + 1;
            }

            // Right half is sorted
            else {

                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }

        return min;
    }
}
