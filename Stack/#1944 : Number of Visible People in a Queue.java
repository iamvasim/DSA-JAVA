/*
LeetCode 1944 : Number of Visible People in a Queue

Question Link:
https://leetcode.com/problems/number-of-visible-people-in-a-queue/

Topic: Arrays, Stack, Monotonic Stack

Optimal (Monotonic Stack):

1. Traverse the array from right to left.
2. Maintain a monotonic decreasing stack
   containing the heights of people to the right.
3. For each person:
      - Pop all shorter people from the stack.
      - Every popped person is visible, so
        increment the visible count.
      - If the stack is still not empty,
        the first taller person is also visible,
        so increment the count once more.
      - Store the count in the answer array.
      - Push the current person's height onto
        the stack.
4. Return the answer array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {

    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        // Rightmost person cannot see anyone
        st.push(heights[n - 1]);
        ans[n - 1] = 0;

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {

            int count = 0;

            // Current person can see all shorter people
            while (!st.isEmpty() && st.peek() < heights[i]) {

                count++;
                st.pop();
            }

            // Can also see the first taller person
            if (!st.isEmpty()) {
                count++;
            }

            ans[i] = count;

            // Push current person
            st.push(heights[i]);
        }

        return ans;
    }
}
