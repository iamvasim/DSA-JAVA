/*
LeetCode 136 : Single Number

Question Link:
https://leetcode.com/problems/single-number/

Topic: Arrays, Bit Manipulation

Optimal (Bit Manipulation - XOR):

1. Initialize a variable `ans` as 0.
2. Traverse every element in the array.
3. XOR the current element with `ans`.
4. Since x ^ x = 0 and x ^ 0 = x,
   all duplicate elements cancel each other.
5. The remaining value is the element
   that appears only once.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
