/*
LeetCode 78 : Subsets

Question Link:
https://leetcode.com/problems/subsets/

Topic: Recursion, Backtracking

Optimal (Backtracking):

1. At every index, we have two choices:
      - Include the current element.
      - Exclude the current element.
2. Recursively explore both choices.
3. When all elements are processed,
   add the current subset to the answer.
4. Backtrack after including an element.

Time Complexity: O(2^n × n)
Space Complexity: O(n)
*/

class Solution {

    void solve(int[] nums,
               List<List<Integer>> ans,
               List<Integer> list,
               int n,
               int i) {

        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Include current element
        list.add(nums[i]);
        solve(nums, ans, list, n, i + 1);

        // Backtrack
        list.remove(list.size() - 1);

        // Exclude current element
        solve(nums, ans, list, n, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(nums, ans, list, nums.length, 0);

        return ans;
    }
}
