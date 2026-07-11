/*
LeetCode 8 : String to Integer (atoi)

Question Link:
https://leetcode.com/problems/string-to-integer-atoi/

Topic: Strings

Optimal:

1. Remove leading whitespaces.
2. Check the sign (+/-).
3. Read digits one by one.
4. Build the number while checking for overflow.
5. Stop when a non-digit character is encountered.
6. Return the signed integer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {

        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        long num = 0;
        int i = 0;
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() && isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = (num * 10) + digit;

            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }
}
