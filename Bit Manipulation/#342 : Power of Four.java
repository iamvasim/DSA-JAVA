/*
LeetCode 342 : Power of Four

Question Link:
https://leetcode.com/problems/power-of-four/

Topic: Bit Manipulation, Math

Brute Force (Repeated Division):

1. If the number is less than or equal to 0,
   return false.
2. Repeatedly divide the number by 4 while
   it is divisible by 4.
3. After the loop, if the number becomes 1,
   it is a power of four.
4. Otherwise, return false.

Time Complexity: O(log₄ n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n = n / 4;
        }

        return n == 1;
    }
}/*
LeetCode 342 : Power of Four

Question Link:
https://leetcode.com/problems/power-of-four/

Topic: Math

Better (Logarithm):

1. If the number is 0,
   return false.
2. Compute x = log₄(n).
3. Check whether 4ˣ equals n.
4. If yes, return true.
5. Otherwise, return false.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPowerOfFour(int n) {

        if (n == 0) {
            return false;
        }

        int x = (int) (Math.log(n) / Math.log(4));

        return Math.pow(4, x) == n;
    }
}/*
LeetCode 342 : Power of Four

Question Link:
https://leetcode.com/problems/power-of-four/

Topic: Bit Manipulation

Optimal (Bit Manipulation):

1. If the number is less than or equal to 0,
   return false.
2. Check whether the number is a power of two
   using (n & (n - 1)) == 0.
3. For powers of four, (n - 1) is always divisible by 3.
4. If both conditions are true,
   return true.
5. Otherwise, return false.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}
