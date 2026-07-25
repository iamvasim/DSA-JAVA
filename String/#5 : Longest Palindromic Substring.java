/*
LeetCode 5 : Longest Palindromic Substring

Question Link:
https://leetcode.com/problems/longest-palindromic-substring/

Topic: Strings, Two Pointers

Optimal (Expand Around Center):

1. Assume every character is the center of a palindrome.
2. Expand around the current character to find the
   longest odd-length palindrome.
3. Expand around the current character and the next
   character to find the longest even-length palindrome.
4. Keep track of the longest palindrome found.
5. Return the longest palindromic substring.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public String longestPalindrome(String s) {

        if (s.length() < 1) {
            return s;
        }

        String lps = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            int low = i;
            int high = i;

            while (low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            String palindrome = s.substring(low + 1, high);

            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }

            // Even-length palindrome
            low = i;
            high = i + 1;

            while (low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            palindrome = s.substring(low + 1, high);

            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }
        }

        return lps;
    }
}
