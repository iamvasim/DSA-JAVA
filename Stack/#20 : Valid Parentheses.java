/*
LeetCode 20 : Valid Parentheses

Question Link:
https://leetcode.com/problems/valid-parentheses/

Topic: Stack, Strings

Optimal (Stack):

1. Traverse the string character by character.
2. If the current character is an opening bracket
   ('(', '{', '['), push it onto the stack.
3. If the current character is a closing bracket:
      - If the stack is empty, return false.
      - Otherwise, check whether the top of the
        stack matches the corresponding opening
        bracket.
      - If it matches, pop the stack.
      - Otherwise, return false.
4. After processing all characters, the stack
   should be empty for the string to be valid.
5. Return true if the stack is empty,
   otherwise return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {

                st.push(ch);

            } else {

                // Closing bracket without opening bracket
                if (st.isEmpty()) {
                    return false;
                }

                // Matching bracket found
                if ((ch == ')' && st.peek() == '(') ||
                    (ch == '}' && st.peek() == '{') ||
                    (ch == ']' && st.peek() == '[')) {

                    st.pop();

                } else {

                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
