/*
LeetCode 9 : Palindrome Number

Question Link:
https://leetcode.com/problems/palindrome-number/

Topic: Recursion, Mathematics

Brute Force (Recursion):

1. If the number is negative,
   return false.
2. Recursively reverse the number.
3. Compare the reversed number
   with the original number.
4. If both are equal,
   return true; otherwise false.

Time Complexity: O(d)
Space Complexity: O(d)

where d = number of digits.
*/

class Solution {
    static int rev;

    static void helper(int x) {
        if (x == 0) {
            return;
        }

        int digit = x % 10;
        rev = rev * 10 + digit;

        helper(x / 10);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        rev = 0;
        int original = x;
        helper(x);

        return original == rev;
    }
}

/*
LeetCode 9 : Palindrome Number

Question Link:
https://leetcode.com/problems/palindrome-number/

Topic: Mathematics

Optimal (Reverse Number):

1. If the number is negative,
   return false.
2. Reverse the number using
   modulo and division.
3. Compare the reversed number
   with the original number.
4. If both are equal,
   return true; otherwise false.

Time Complexity: O(d)
Space Complexity: O(1)

where d = number of digits.
*/

class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x > 0) {

            int digit = x % 10;

            reverse = reverse * 10 + digit;

            x = x / 10;
        }

        return original == reverse;
    }
}
