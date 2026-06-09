/*
Lower Bound

Brute Force:
Traverse the array from left to right.
Return the first index where nums[i] >= x.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int lowerBound(int[] nums, int x) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= x) {
                return i;
            }
        }

        return nums.length;
    }
}


/*
Lower Bound

Optimal (Binary Search):
Since the array is sorted, use Binary Search.

If nums[mid] >= x:
    Store mid as a potential answer.
    Search on the left side.

Otherwise:
    Search on the right side.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int lowerBound(int[] nums, int x) {

        int ans = nums.length;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
