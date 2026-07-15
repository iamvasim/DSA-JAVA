/*
TUF : Count All Subsequences with Sum K

Question Link:
https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k

Topic: Recursion, Backtracking

Brute Force (Generate All Subsequences):

1. Generate all possible subsequences.
2. For every subsequence, calculate its sum.
3. If the sum equals k, increase the count.
4. Return the total count.

Time Complexity: O(2^n × n)
Space Complexity: O(n)
*/

class Solution {

    int count = 0;

    boolean isSum(List<Integer> curr, int k) {

        int sum = 0;

        for (int num : curr) {
            sum += num;
        }

        return sum == k;
    }

    void solve(int[] nums,
               int k,
               List<Integer> curr,
               int i,
               int n) {

        if (i == n) {

            if (isSum(curr, k)) {
                count++;
            }

            return;
        }

        // Include current element
        curr.add(nums[i]);
        solve(nums, k, curr, i + 1, n);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Exclude current element
        solve(nums, k, curr, i + 1, n);
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {

        List<Integer> curr = new ArrayList<>();

        solve(nums, k, curr, 0, nums.length);

        return count;
    }
}
/*
TUF : Count All Subsequences with Sum K

Question Link:
https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k

Topic: Recursion, Backtracking

Optimal (Running Sum):

1. At every index, choose:
      - Include the current element.
      - Exclude the current element.
2. Maintain the current sum during recursion.
3. When all elements are processed,
   check whether the current sum equals k.
4. Count all valid subsequences.

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

class Solution {

    int count = 0;

    void solve(int[] nums,
               int k,
               int i,
               int n,
               int currSum) {

        if (i == n) {

            if (currSum == k) {
                count++;
            }

            return;
        }

        // Include current element
        solve(nums, k, i + 1, n, currSum + nums[i]);

        // Exclude current element
        solve(nums, k, i + 1, n, currSum);
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {

        count = 0;

        solve(nums, k, 0, nums.length, 0);

        return count;
    }
}
