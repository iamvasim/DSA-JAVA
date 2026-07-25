/*
LeetCode 13 : Roman to Integer

Question Link:
https://leetcode.com/problems/roman-to-integer/

Topic: Strings

Optimal (Greedy):

1. Traverse the Roman numeral from left to right.
2. Convert the current Roman character to its integer value.
3. If the current value is smaller than the next value,
   subtract it from the answer.
4. Otherwise, add it to the answer.
5. Continue until all characters are processed.
6. Return the final integer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int romanToInt(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int val = getValue(s.charAt(i));

            if (i < s.length() - 1 && val < getValue(s.charAt(i + 1))) {
                ans -= val;
            } else {
                ans += val;
            }
        }

        return ans;
    }

    int getValue(char ch) {

        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;

        return 1000;
    }
}
