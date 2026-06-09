/*
LeetCode 1752 : Check if Array Is Sorted and Rotated

Brute Force:
Generate every possible rotation of the array.
For each rotation, check if the array is sorted in non-decreasing order.
If any rotation is sorted, return true; otherwise return false.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public boolean check(int[] nums) {

        int n = nums.length;

        // Try every possible rotation
        for (int start = 0; start < n; start++) {

            boolean sorted = true;

            // Check if this rotation is sorted
            for (int i = 1; i < n; i++) {

                int prev = nums[(start + i - 1) % n];
                int curr = nums[(start + i) % n];

                if (prev > curr) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return true;
            }
        }

        return false;
    }
}

/*


Optimized:
Count the number of indices where
nums[i] > nums[(i + 1) % n].

A sorted and rotated array can have at most one such index.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean check(int[] nums) {

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}
