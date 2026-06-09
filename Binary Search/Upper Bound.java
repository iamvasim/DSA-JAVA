/*
Upper Bound

Brute Force:
Traverse the array from left to right.
Return the first index where nums[i] > x.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int upperBound(int[] nums, int x) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > x) {
                return i;
            }
        }

        return nums.length;
    }
}

/*
Upper Bound

Optimal (Binary Search):
Since the array is sorted, use Binary Search.

If nums[mid] > x:
    Store mid as a potential answer.
    Search on the left side.

Otherwise:
    Search on the right side.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int upperBound(int[] nums, int x) {

        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
