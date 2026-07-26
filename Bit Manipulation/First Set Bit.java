/*
GFG : First Set Bit

Question Link:
https://www.geeksforgeeks.org/problems/first-set-bit5640/1

Topic: Bit Manipulation

Optimal (Bit Manipulation):

1. If the number is 0, return 0 since no bit is set.
2. Initialize the position as 1 (1-based indexing).
3. Check the least significant bit using (n & 1).
4. If it is not set, right shift the number by one bit
   and increment the position.
5. Repeat until the least significant bit becomes 1.
6. Return the position of the first set bit.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public static int getFirstSetBit(int n) {

        if (n == 0) {
            return 0;
        }

        int pos = 1;

        while ((n & 1) == 0) {

            n = n >> 1;
            pos++;
        }

        return pos;
    }
}
