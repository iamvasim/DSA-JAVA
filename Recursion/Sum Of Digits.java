/*
GeeksforGeeks : Sum Of Digits

Question Link:
https://www.geeksforgeeks.org/problems/sum-of-digits1742/1

Topic: Recursion

Approach:

1. If n becomes 0, return 0.
2. Extract the last digit using (n % 10).
3. Recursively calculate the sum of digits of (n / 10).
4. Add the last digit to the recursive result.
5. Return the final sum.

Time Complexity: O(d)
Space Complexity: O(d)

where d = number of digits in n.
*/

class Solution {

    static int sumOfDigits(int n) {

        // Base Condition
        if (n == 0) {
            return 0;
        }

        return (n % 10) + sumOfDigits(n / 10);
    }
}
