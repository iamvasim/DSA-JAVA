/*
LeetCode 503 : Next Greater Element II

Question Link:
https://leetcode.com/problems/next-greater-element-ii/

Topic: Arrays, Stack, Monotonic Stack

Optimal (Monotonic Stack):

1. Since the array is circular, first push all
   elements (from right to left) into the stack.
2. Traverse the array again from right to left.
3. For each element:
      - Remove all elements from the stack that are
        smaller than or equal to the current element.
      - If the stack becomes empty, the next greater
        element is -1.
      - Otherwise, the top of the stack is the
        next greater element.
      - Push the current element onto the stack.
4. Return the answer array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();

        // Push all elements to simulate circular array
        for (int i = nums.length - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        int[] ans = new int[nums.length];

        // Find next greater element
        for (int i = nums.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(nums[i]);
        }

        return ans;
    }
}
