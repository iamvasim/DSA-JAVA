/*
LeetCode 70 : Climbing Stairs

Question Link:
https://leetcode.com/problems/climbing-stairs/

Topic: Dynamic Programming, Recursion

Brute Force (Recursion):

1. If n <= 2, return n.
2. The number of ways to reach step n is:
      ways(n-1) + ways(n-2)
3. Recursively calculate both possibilities.

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

class Solution {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
