/*
LeetCode 796 : Rotate String

Question Link:
https://leetcode.com/problems/rotate-string/

Topic: Strings

Brute Force (Try Every Rotation):

1. If the lengths of both strings are different,
   return false.
2. Generate every possible rotation of the string.
3. For each rotation, compare it with the goal string.
4. If any rotation matches,
   return true.
5. If no rotation matches,
   return false.

Time Complexity: O(n²)
Space Complexity: O(n)
*/

class SolutionBrute {

    public boolean rotateString(String s, String goal) {

        // Length different → impossible
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();

        // Try every possible rotation
        for (int shift = 0; shift < n; shift++) {

            // Rotate string
            String rotated = s.substring(shift) + s.substring(0, shift);

            if (rotated.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}

/*
LeetCode 796 : Rotate String

Question Link:
https://leetcode.com/problems/rotate-string/

Topic: Strings

Optimal (String Concatenation):

1. If the lengths of both strings are different,
   return false.
2. Concatenate the original string with itself.
3. If the goal string is a substring of the
   concatenated string, then it can be obtained
   by rotating the original string.
4. Otherwise, return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}
