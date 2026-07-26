/*
GFG : Set K-th Bit

Question Link:
https://www.geeksforgeeks.org/problems/set-kth-bit3724/1

Topic: Bit Manipulation

Optimal (Bit Masking):

1. Create a mask by left shifting 1 by k positions.
2. The mask has only the k-th bit set to 1.
3. Perform bitwise OR between n and the mask.
4. OR sets the k-th bit to 1 while leaving all
   other bits unchanged.
5. Return the updated number.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    static int setKthBit(int n, int k) {

        int mask = 1 << k;

        return n | mask;
    }
}
