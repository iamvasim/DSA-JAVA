/*
LeetCode 205 : Isomorphic Strings

Question Link:
https://leetcode.com/problems/isomorphic-strings/

Topic: Strings, HashMap

Optimal (HashMap):

1. If the lengths of both strings are different,
   return false.
2. Traverse both strings simultaneously.
3. Maintain a HashMap to store the mapping
   from characters of s to characters of t.
4. If a character is already mapped,
   verify that it maps to the current character.
5. If it is not mapped, ensure that the target
   character is not already mapped to another
   character using containsValue().
6. If all mappings are valid,
   return true.

Time Complexity: O(n²)
(Note: containsValue() takes O(n) time for each iteration.)

Space Complexity: O(n)
*/

class Solution {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if (map.containsKey(sch)) {

                if (map.get(sch) != tch) {
                    return false;
                }

            } else {

                if (map.containsValue(tch)) {
                    return false;
                }

                map.put(sch, tch);
            }
        }

        return true;
    }
}
