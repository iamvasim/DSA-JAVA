/*
LeetCode 1614 : Maximum Nesting Depth of the Parentheses

Question Link:
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

Topic: Strings

Optimal (Depth Counting):

1. Initialize two variables:
      - depth to track the current nesting level.
      - maxDepth to store the maximum depth.
2. Traverse each character of the string.
3. If the character is '(':
      - Increment depth.
      - Update maxDepth if depth is greater.
4. If the character is ')':
      - Decrement depth.
5. Ignore all other characters.
6. Return maxDepth.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxDepth(String s) {

        int depth = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                depth++;

                if (depth > max) {
                    max = depth;
                }

            } else if (ch == ')') {

                depth--;
            }
        }

        return max;
    }
}
