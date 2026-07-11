/*
LeetCode 1922 : Count Good Numbers

Question Link:
https://leetcode.com/problems/count-good-numbers/

Topic: Recursion, Mathematics

Optimal (Binary Exponentiation):

1. Count even index positions:
      even = (n + 1) / 2
2. Count odd index positions:
      odd = n / 2
3. Even positions have 5 choices:
      {0, 2, 4, 6, 8}
4. Odd positions have 4 choices:
      {2, 3, 5, 7}
5. Compute:
      (5^even × 4^odd) % MOD
   using Binary Exponentiation.

Time Complexity: O(log n)
Space Complexity: O(log n)
*/

class Solution {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int) ((pow(5, even) * pow(4, odd)) % MOD);
    }

    static long pow(long a, long b) {

        if (b == 0)
            return 1;

        long half = pow(a, b / 2);

        long ans = (half * half) % MOD;

        if (b % 2 == 1) {
            ans = (ans * a) % MOD;
        }

        return ans;
    }
}
