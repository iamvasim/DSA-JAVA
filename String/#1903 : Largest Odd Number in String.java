/*
LeetCode 1903 : Largest Odd Number in String

Question Link:
https://leetcode.com/problems/largest-odd-number-in-string/

Topic: Strings, Greedy

Optimal (Greedy):

1. Traverse the string from right to left.
2. Find the first digit that is odd.
3. Since removing characters only from the end gives the
   largest possible odd substring, return the substring
   from index 0 to that odd digit.
4. If no odd digit exists, return an empty string.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {

            int digit = num.charAt(i) - '0';

            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
