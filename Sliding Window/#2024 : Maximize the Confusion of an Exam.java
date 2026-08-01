/*
LeetCode 2024 : Maximize the Confusion of an Exam

Question Link:
https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

Topic: Strings, Sliding Window, Two Pointers

Optimal (Sliding Window):

1. Find the longest substring that can be made
   entirely 'T' by flipping at most k 'F's.
2. Find the longest substring that can be made
   entirely 'F' by flipping at most k 'T's.
3. For each case:
      - Maintain a sliding window.
      - Count characters that need to be flipped.
      - If the count exceeds k, shrink the window
        from the left.
      - Update the maximum valid window length.
4. Return the maximum of both results.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    static int findMax(String s, int k, char ch) {

        int n = s.length();

        int left = 0;
        int flipCount = 0;
        int maxLen = 0;

        // Expand the window
        for (int right = 0; right < n; right++) {

            if (s.charAt(right) != ch) {
                flipCount++;
            }

            // Shrink the window if flips exceed k
            while (flipCount > k) {

                if (s.charAt(left) != ch) {
                    flipCount--;
                }

                left++;
            }

            // Update the maximum valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        int maxF = findMax(answerKey, k, 'F');
        int maxT = findMax(answerKey, k, 'T');

        return Math.max(maxF, maxT);
    }
}
