/*
LeetCode - 35. Search Insert Position

Brute Force:
Traverse the array from left to right.
If nums[i] >= target, return i.
If no such index exists, return nums.length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
}

/*


Optimal (Binary Search):
Since the array is sorted, use Binary Search.

If target is found, return its index.
Otherwise, return the position where it can be inserted
while maintaining sorted order.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
