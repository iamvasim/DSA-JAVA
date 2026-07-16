/*
LeetCode 125 : Valid Palindrome

Question Link:
https://leetcode.com/problems/valid-palindrome/

Topic: Strings, Two Pointers

Optimal (Two Pointers):

1. Convert the string to lowercase.
2. Remove all non-alphanumeric characters.
3. Place one pointer at the beginning
   and one at the end.
4. Compare both characters:
      - If different, return false.
      - Otherwise move both pointers.
5. If all characters match,
   return true.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
