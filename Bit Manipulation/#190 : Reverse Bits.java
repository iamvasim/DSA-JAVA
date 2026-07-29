/*
LeetCode 190 : Reverse Bits

Question Link:
https://leetcode.com/problems/reverse-bits/

Topic: Bit Manipulation

Optimal (Bit Manipulation):

1. Initialize the result as 0.
2. Repeat 32 times (for every bit of an integer).
3. Left shift the result by 1 to make space for
   the next bit.
4. Extract the least significant bit of n using
   (n & 1).
5. Add the extracted bit to the result using OR.
6. Right shift n by 1 to process the next bit.
7. After processing all 32 bits, return the result.

Time Complexity: O(32) ≈ O(1)
Space Complexity: O(1)
*/

class Solution {

    public int reverseBits(int n) {

        int res = 0;

        for (int i = 1; i <= 32; i++) {

            // Make space for the next bit
            res = res << 1;

            // Extract the last bit of n
            int last = (n & 1);

            // Append it to the result
            res = res | last;

            // Move to the next bit
            n = n >> 1;
        }

        return res;
    }
}
