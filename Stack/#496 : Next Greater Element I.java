/*
LeetCode 496 : Next Greater Element I

Question Link:
https://leetcode.com/problems/next-greater-element-i/

Topic: Stack, Monotonic Stack, HashMap

Optimal (Monotonic Stack + HashMap):

1. Traverse nums2 from right to left.
2. Maintain a monotonic decreasing stack.
3. For each element:
      - Remove all smaller elements from the stack.
      - If the stack is empty, its next greater
        element is -1.
      - Otherwise, the top of the stack is its
        next greater element.
      - Store this mapping in a HashMap.
      - Push the current element onto the stack.
4. Traverse nums1 and use the HashMap to get
   the next greater element for each number.
5. Return the result array.

Time Complexity: O(n + m)
Space Complexity: O(n)

(where n = nums2.length, m = nums1.length)
*/

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();

        // Stores: element -> next greater element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Remove all smaller elements
            while (!st.isEmpty() && nums2[i] > st.peek()) {
                st.pop();
            }

            // Store next greater element
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            // Push current element
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        // Build answer for nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
