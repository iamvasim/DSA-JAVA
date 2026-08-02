/*
LeetCode 1047 : Remove All Adjacent Duplicates In String

Question Link:
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

Topic: Strings, Stack

Optimal (Stack):

1. Traverse the string character by character.
2. If the stack is empty or the current character
   is different from the top of the stack,
   push the character.
3. Otherwise, the current character and the top
   of the stack are adjacent duplicates,
   so pop the top element.
4. After processing all characters, the stack
   contains the final string.
5. Build and return the answer from the stack.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (st.isEmpty() || st.peek() != ch) {
                st.push(ch);
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }
}/*
LeetCode 1047 : Remove All Adjacent Duplicates In String

Question Link:
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

Topic: Strings

Optimal (StringBuilder as Stack):

1. Use a StringBuilder to simulate a stack.
2. Traverse the string character by character.
3. If the last character in the StringBuilder
   matches the current character,
   remove it (pop).
4. Otherwise, append the current character (push).
5. After processing all characters,
   return the StringBuilder as the answer.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            int len = sb.length();

            if (len > 0 && sb.charAt(len - 1) == ch) {

                sb.deleteCharAt(len - 1); // Pop

            } else {

                sb.append(ch); // Push
            }
        }

        return sb.toString();
    }
}
