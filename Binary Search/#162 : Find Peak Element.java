/*
162. Find Peak Element

Better:
Check every element and determine whether it is
greater than both of its neighbours.

Handle first and last elements separately.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        // Only one element
        if (n == 1) {
            return 0;
        }

        // First element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Middle elements
        for (int i = 1; i < n - 1; i++) {

            if (nums[i] > nums[i - 1]
                    && nums[i] > nums[i + 1]) {

                return i;
            }
        }

        // Last element
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        return -1;
    }
}




/*
162. Find Peak Element

Optimal (Binary Search):

If nums[mid] > nums[mid + 1],
a peak exists on the left side (including mid).

Otherwise,
a peak exists on the right side.

Use Binary Search to locate a peak.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1]
                    && nums[mid] > nums[mid + 1]) {

                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
