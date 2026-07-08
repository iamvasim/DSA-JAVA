/*
Factorial of a Number using Recursion

Question Link:
https://www.geeksforgeeks.org/program-for-factorial-of-a-number/

Topic: Recursion

Approach:

1. If n is 0 or 1, return 1.
2. Otherwise return:
      n × factorial(n - 1)
3. The recursion continues until it reaches the base case.
4. While returning, each recursive call multiplies its value.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public static int fact(int n) {

        // Base Condition
        if (n <= 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
}
