/*
LeetCode 3689 : Maximum Total Subarray Value I

Brute Force:
Generate all possible subarrays.
For each subarray, calculate its maximum and minimum element.
Keep track of the maximum value of (max - min).

Time Complexity: O(n³)
Space Complexity: O(n²)
*/

class Solution {

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                ArrayList<Integer> temp = new ArrayList<>();

                for (int z = i; z <= j; z++) {
                    temp.add(nums[z]);
                }

                list.add(temp);
            }
        }

        long ans = Long.MIN_VALUE;

        for (ArrayList<Integer> sub : list) {

            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            for (long num : sub) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            ans = Math.max(ans, max - min);
        }

        return ans * k;
    }
}



/*

Optimized:
Since we can choose the same subarray multiple times,
we only need the maximum possible value of any subarray.

The maximum value is obtained by taking a subarray
containing both the global minimum and global maximum.

Maximum Subarray Value = Global Maximum - Global Minimum

Answer = k × (Global Maximum - Global Minimum)

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public long maxTotalValue(int[] nums, int k) {

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return (max - min) * k;
    }
}
