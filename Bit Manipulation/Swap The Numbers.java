/*
GFG : Swap The Numbers

Question Link:
https://www.geeksforgeeks.org/problems/swap-the-numbers3844/1

Topic: Bit Manipulation

Optimal (XOR Swap):

1. XOR both numbers and store the result in `a`.
2. XOR the updated `a` with `b` to recover the
   original value of `a`, and store it in `b`.
3. XOR the updated `a` with the updated `b`
   to recover the original value of `b`,
   and store it in `a`.
4. Print the swapped values.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public void swap(int a, int b) {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);
    }
}
