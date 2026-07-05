/*
LeetCode 509 : Fibonacci Number

Question Link:
https://leetcode.com/problems/fibonacci-number/

Topic: Recursion



1. If n is 0 or 1, return n.
2. Otherwise,
      Fibonacci(n) =
      Fibonacci(n - 1) + Fibonacci(n - 2).
3. Keep recursively solving smaller subproblems.
4. Return the final Fibonacci number.

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

class Solution {

    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
