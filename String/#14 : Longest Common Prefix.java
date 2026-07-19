/*
LeetCode 14 : Longest Common Prefix

Question Link:
https://leetcode.com/problems/longest-common-prefix/

Topic: Strings

Optimal (Horizontal Scanning):

1. Assume the first string is the common prefix.
2. Compare the prefix with every other string.
3. While the current string does not start with the prefix,
   remove the last character from the prefix.
4. If the prefix becomes empty,
   return an empty string.
5. After processing all strings,
   the remaining prefix is the longest common prefix.

Time Complexity: O(n × m)
where n = number of strings,
      m = length of the shortest common prefix.

Space Complexity: O(1)
*/

class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
