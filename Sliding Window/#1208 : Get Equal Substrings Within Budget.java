/*
LeetCode 1208 : Get Equal Substrings Within Budget

Question Link:
https://leetcode.com/problems/get-equal-substrings-within-budget/

Topic: Strings, Sliding Window, Two Pointers

Optimal (Sliding Window):

1. Maintain a sliding window using two pointers:
      - start: left boundary.
      - end: right boundary.
2. For every new character, add its conversion cost
   |s[end] - t[end]| to the current window cost.
3. If the current cost exceeds maxCost,
   shrink the window from the left by removing
   the corresponding conversion cost.
4. Once the window becomes valid, update the
   maximum window length.
5. Return the maximum valid substring length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int equalSubstring(String s, String t, int maxCost) {

        int n = s.length();

        int maxLen = 0;
        int currCost = 0;
        int start = 0;

        // Expand the window
        for (int end = 0; end < n; end++) {

            currCost += Math.abs(s.charAt(end) - t.charAt(end));

            // Shrink the window until the cost is within budget
            while (currCost > maxCost) {

                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            // Update the maximum valid window length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
