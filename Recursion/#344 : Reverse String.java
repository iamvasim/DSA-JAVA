/*
LeetCode 344 : Reverse String

Question Link:
https://leetcode.com/problems/reverse-string/

Topic: Recursion, Two Pointers

Brute Force (Using Extra Array):

1. Create an ArrayList to store characters.
2. Recursively traverse the string till the end.
3. While returning from recursion,
   store the characters in the ArrayList.
4. Copy the characters back into the original array.
5. The original array becomes reversed.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {

    static void helper(char[] s,
                       int index,
                       ArrayList<Character> list) {

        if (index == s.length) {
            return;
        }

        helper(s, index + 1, list);

        list.add(s[index]);
    }

    public void reverseString(char[] s) {

        ArrayList<Character> list = new ArrayList<>();

        helper(s, 0, list);

        for (int i = 0; i < s.length; i++) {
            s[i] = list.get(i);
        }
    }
}
/*
LeetCode 344 : Reverse String

Question Link:
https://leetcode.com/problems/reverse-string/

Topic: Recursion, Two Pointers

Optimal (In-place Recursion):

1. Initialize two pointers:
      left = 0
      right = n - 1
2. Swap the characters at left and right.
3. Recursively call for:
      left + 1
      right - 1
4. Stop when left >= right.
5. The array gets reversed in-place.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    static void helper(char[] s,
                       int left,
                       int right) {

        if (left >= right) {
            return;
        }

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        helper(s, left + 1, right - 1);
    }

    public void reverseString(char[] s) {

        helper(s, 0, s.length - 1);
    }
}
