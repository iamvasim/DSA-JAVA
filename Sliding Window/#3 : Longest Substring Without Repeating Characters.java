/*
LeetCode 3 : Longest Substring Without Repeating Characters

Question Link:
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Topic: Strings, Sliding Window, HashSet

Optimal (Sliding Window + HashSet):

1. Maintain a sliding window using two pointers:
      - left: left boundary.
      - right: right boundary.
2. Use a HashSet to store the unique characters
   present in the current window.
3. Expand the window by moving the right pointer.
4. If the current character is already present,
   shrink the window from the left until the
   duplicate is removed.
5. Add the current character to the window.
6. Update the maximum window length.
7. Return the maximum length.

Time Complexity: O(n)
Space Complexity: O(min(n, charset))
*/

class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int left = 0;
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();

        // Expand the window
        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            // Shrink the window until duplicate is removed
            while (set.contains(ch)) {

                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(ch);

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
