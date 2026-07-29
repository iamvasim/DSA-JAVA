/*
LeetCode 338 : Counting Bits

Question Link:
https://leetcode.com/problems/counting-bits/

Topic: Bit Manipulation

Brute Force (Count Set Bits for Every Number):

1. Create an array of size n + 1.
2. Traverse every number from 0 to n.
3. For each number, repeatedly:
      - Check the least significant bit using (num & 1).
      - Add it to the count.
      - Right shift the number by 1.
4. Store the count in the answer array.
5. Return the answer array.

Time Complexity: O(n log n)
Space Complexity: O(1)
(Excluding the output array)
*/

class Solution {

    public int[] countBits(int n) {

        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            int one = 0;
            int num = i;

            while (num > 0) {

                one += (num & 1);

                num = num >> 1;
            }

            ans[i] = one;
        }

        return ans;
    }
}
