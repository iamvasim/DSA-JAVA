/*
LeetCode 231 : Power of Two

Question Link:
https://leetcode.com/problems/power-of-two/

Topic: Bit Manipulation

Brute Force (Count Set Bits):

1. If the number is less than or equal to 0,
   it cannot be a power of two.
2. Traverse all bits of the number.
3. Count the number of set bits.
4. If exactly one bit is set,
   return true.
5. Otherwise, return false.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        int one = 0;

        while (n > 0) {

            if ((n & 1) == 1) {
                one++;
            }

            n = n >> 1;
        }

        return one == 1;
    }
}/*
LeetCode 231 : Power of Two

Question Link:
https://leetcode.com/problems/power-of-two/

Topic: Bit Manipulation

Optimal (n & (n - 1)):

1. A power of two has exactly one set bit.
2. Subtracting 1 flips that set bit and all
   lower bits.
3. Performing n & (n - 1) removes the only set bit.
4. If the result is 0 and n is positive,
   then n is a power of two.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPowerOfTwo(int n) {

        return n > 0 && ((n & (n - 1)) == 0);
    }
}
