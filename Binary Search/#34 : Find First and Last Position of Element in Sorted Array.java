/*
LeetCode 34. Find First and Last Position of Element in Sorted Array

Brute Force:
Traverse the array twice.
First traversal finds the first occurrence.
Second traversal finds the last occurrence.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                last = i;
            }
        }

        return new int[]{first, last};
    }
}


/*


Better:
Traverse the array only once.
When target is found:
- Set first occurrence if not already set.
- Keep updating last occurrence.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {

                if (first == -1) {
                    first = i;
                }

                last = i;
            }
        }

        return new int[]{first, last};
    }
}



/*


Optimal (Binary Search):

Use Binary Search twice:
1. Find the first occurrence.
2. Find the last occurrence.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    private int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return index;
    }

    private int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                left = mid + 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return index;
    }

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }
}
