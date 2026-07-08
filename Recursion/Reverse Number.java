/*
Reverse Number

Question Link:
https://www.geeksforgeeks.org/reverse-a-number-in-java/

Topic: Recursion, Mathematics

Iterative:

1. Initialize reverse = 0.
2. Extract the last digit using (n % 10).
3. Append the digit to the reversed number.
4. Remove the last digit using (n / 10).
5. Repeat until n becomes 0.
6. Return the reversed number.

Time Complexity: O(d)
Space Complexity: O(1)

where d = number of digits.
*/

class Solution {

    static int reverse(int n) {

        int reverse = 0;

        while (n > 0) {

            int digit = n % 10;

            reverse = reverse * 10 + digit;

            n = n / 10;
        }

        return reverse;
    }
}
/*
Reverse Number

Question Link:
https://www.geeksforgeeks.org/reverse-a-number-in-java/

Topic: Recursion

Recursive:

1. If n becomes 0, stop recursion.
2. Extract the last digit using (n % 10).
3. Append it to the answer.
4. Recursively call reverse(n / 10).
5. After recursion ends, the reversed number is stored in 'sum'.

Time Complexity: O(d)
Space Complexity: O(d)

where d = number of digits.
*/

class Solution {

    static int sum = 0;

    static void reverse(int n) {

        // Base Condition
        if (n == 0) {
            return;
        }

        int digit = n % 10;

        sum = sum * 10 + digit;

        reverse(n / 10);
    }
}
