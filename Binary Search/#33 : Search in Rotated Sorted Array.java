/*
33. Search in Rotated Sorted Array

Brute Force:
Traverse the entire array and check each element.
If target is found, return its index.
Otherwise, return -1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}


/*

Optimal (Binary Search):

At least one half of the array is always sorted.

1. Find the sorted half.
2. Check if the target lies in that half.
3. If yes, search there.
4. Otherwise, search in the other half.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
