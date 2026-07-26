/*
LeetCode 2220 : Minimum Bit Flips to Convert Number

Question Link:
https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

Topic: Bit Manipulation

Optimal (XOR + Count Set Bits):

1. Perform XOR between start and goal.
2. XOR produces 1 at every position where the
   bits are different.
3. Traverse all 32 bit positions.
4. Check whether each bit is set using
   (ans & (1 << i)).
5. Count all the set bits.
6. The count represents the minimum number
   of bit flips required.

Time Complexity: O(32) ≈ O(1)
Space Complexity: O(1)
*/

class Solution {

    public int minBitFlips(int start, int goal) {

        int count = 0;

        // XOR gives 1 where bits are different
        int ans = start ^ goal;

        // Check all 32 bits
        for (int i = 0; i < 32; i++) {

            if ((ans & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
