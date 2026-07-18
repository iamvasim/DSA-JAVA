/*
LeetCode 1021 : Remove Outermost Parentheses

Question Link:
https://leetcode.com/problems/remove-outermost-parentheses/

Topic: Strings

Optimal (Depth Counting):

1. Maintain a variable `depth` to track the current nesting level.
2. For every opening parenthesis '(':
      - Increase the depth.
      - Append it only if the depth becomes greater than 1.
3. For every closing parenthesis ')':
      - Decrease the depth.
      - Append it only if the remaining depth is greater than 0.
4. The first '(' and the last ')' of every primitive substring
   are skipped automatically.
5. Return the constructed string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                depth++;

                if (depth > 1) {
                    ans.append(ch);
                }

            } else {

                depth--;

                if (depth > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}
