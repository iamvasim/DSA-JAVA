/*
LeetCode 191 : Number of 1 Bits

Question Link:
https://leetcode.com/problems/number-of-1-bits/

Topic: Bit Manipulation

Brute Force (Right Shift):

1. Initialize a counter to 0.
2. Traverse all bits of the number by repeatedly
   right shifting it.
3. Check the least significant bit using (n & 1).
4. If it is 1, increment the counter.
5. Continue until the number becomes 0.
6. Return the count of set bits.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int hammingWeight(int n) {

        int one = 0;

        while (n > 0) {

            if ((n & 1) == 1) {
                one++;
            }

            n = n >> 1;
        }

        return one;
    }
}/*
LeetCode 191 : Number of 1 Bits

Question Link:
https://leetcode.com/problems/number-of-1-bits/

Topic: Bit Manipulation

Better (Check Every Bit Position):

1. Initialize a counter to 0.
2. Traverse every bit position from 0 to 30.
3. Right shift the number by i positions.
4. Check the least significant bit using modulo 2.
5. If the bit is set, increment the counter.
6. Return the total number of set bits.

Time Complexity: O(32) ≈ O(1)
Space Complexity: O(1)
*/

class Solution {

    public int hammingWeight(int n) {

        int one = 0;

        for (int i = 0; i < 32; i++) {

            if (((n >> i) % 2) != 0) {
                one++;
            }
        }

        return one;
    }
}
