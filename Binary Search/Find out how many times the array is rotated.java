/*
Find out how many times the array is rotated

Brute Force:
Find the minimum element in the array.
The index of the minimum element is the number of rotations.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findKRotation(ArrayList<Integer> nums) {

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < nums.size(); i++) {

            if (nums.get(i) < min) {
                min = nums.get(i);
                index = i;
            }
        }

        return index;
    }
}


/*
Find out how many times the array is rotated

Optimal (Binary Search):

The number of rotations is equal to the index
of the minimum element.

1. If the current range is already sorted,
   nums[low] is the minimum.
2. If the left half is sorted,
   search in the right half.
3. Otherwise, search in the left half.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int findKRotation(ArrayList<Integer> nums) {

        int low = 0;
        int high = nums.size() - 1;

        int min = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Entire range is sorted
            if (nums.get(low) <= nums.get(high)) {

                if (nums.get(low) < min) {
                    min = nums.get(low);
                    index = low;
                }

                break;
            }

            // Left half is sorted
            if (nums.get(low) <= nums.get(mid)) {

                if (nums.get(low) < min) {
                    min = nums.get(low);
                    index = low;
                }

                low = mid + 1;
            }

            // Right half is sorted
            else {

                if (nums.get(mid) < min) {
                    min = nums.get(mid);
                    index = mid;
                }

                high = mid - 1;
            }
        }

        return index;
    }
}
