/*
81. Search in Rotated Sorted Array II

Brute Force:
Traverse the entire array.
If target is found, return true.
Otherwise, return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                return true;
            }
        }

        return false;
    }
}

/*


Optimal (Modified Binary Search):

The array is rotated and may contain duplicates.

1. Find the sorted half.
2. Check if target lies in the sorted half.
3. Search accordingly.
4. If nums[low] == nums[mid] == nums[high],
   shrink the search space by moving both pointers.

Time Complexity:
Average Case: O(log n)
Worst Case: O(n)

Space Complexity: O(1)
*/

class Solution {

    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
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

        return false;
    }
}
