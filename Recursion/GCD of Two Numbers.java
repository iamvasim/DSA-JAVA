/*
GFG : GCD of Two Numbers

Question Link:
https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1

Topic: Mathematics, Recursion

Brute Force:

1. Traverse from 1 to min(a, b).
2. Check if current number divides both a and b.
3. Store the largest common divisor.
4. Return the stored answer.

Time Complexity: O(min(a, b))
Space Complexity: O(1)
*/

class Solution {

    public static int gcd(int a, int b) {

        int ans = 0;

        for (int i = 1; i <= Math.min(a, b); i++) {

            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
        }

        return ans;
    }
}/*
GFG : GCD of Two Numbers

Question Link:
https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1

Topic: Mathematics

Better (Subtraction-Based Euclidean Algorithm):

1. While both numbers are not equal:
      - If a > b, subtract b from a.
      - Otherwise, subtract a from b.
2. Repeat until both become equal.
3. The common value is the GCD.

Time Complexity: O(max(a, b))   // Worst Case
Space Complexity: O(1)
*/

class SolutionSubtraction {

    public static int gcd(int a, int b) {

        // Jab tak a aur b equal nahi ho jaate
        while (a != b) {

            if (a > b) {
                // a zyada bada hai → a se b ghata do
                a = a - b;
            } else {
                // b zyada bada hai → b se a ghata do
                b = b - a;
            }
        }

        // Jab a == b, woh hi GCD hai
        return a;
    }
}/*
GFG : GCD of Two Numbers

Question Link:
https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1

Topic: Mathematics, Recursion

Optimal (Euclidean Algorithm):

1. If a becomes 0,
   return b.
2. Otherwise recursively call:
      gcd(b % a, a)
3. Continue until the base case is reached.

Time Complexity: O(log(min(a, b)))
Space Complexity: O(log(min(a, b)))
*/

class Solution {

    public static int gcd(int a, int b) {

        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
