/*
LeetCode 22 : Generate Parentheses

Question Link:
https://leetcode.com/problems/generate-parentheses/

Topic: Recursion, Backtracking

Brute Force (Generate All + Validate):

1. Generate all possible strings of length 2 * n.
2. At each step, choose:
      - '('
      - ')'
3. When the string length becomes 2 * n,
   check whether it is valid.
4. If valid, add it to the answer.

Time Complexity: O(2^(2n) × n)
Space Complexity: O(2n)
*/

class Solution {

    List<String> res;

    void solve(String curr, int n) {

        if (curr.length() == 2 * n) {

            if (isValid(curr)) {
                res.add(curr);
            }

            return;
        }

        solve(curr + "(", n);
        solve(curr + ")", n);
    }

    boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    public List<String> generateParenthesis(int n) {

        res = new ArrayList<>();

        solve("", n);

        return res;
    }
}/*
LeetCode 22 : Generate Parentheses

Question Link:
https://leetcode.com/problems/generate-parentheses/

Topic: Recursion, Backtracking

Optimal (Backtracking):

1. Keep track of:
      - open brackets used
      - close brackets used
2. Add '(' only if open < n.
3. Add ')' only if close < open.
4. When close == n,
   one valid combination is formed.
5. Add it to the answer.

Time Complexity: O(4^n / √n)
Space Complexity: O(n)
*/

class Solution {

    void solve(int n,
               int open,
               int close,
               String s,
               List<String> ans) {

        if (close == n) {
            ans.add(s);
            return;
        }

        if (open < n) {
            solve(n, open + 1, close, s + "(", ans);
        }

        if (close < open) {
            solve(n, open, close + 1, s + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(n, 0, 0, "", ans);

        return ans;
    }
}
