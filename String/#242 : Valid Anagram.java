/*
LeetCode 242 : Valid Anagram

Question Link:
https://leetcode.com/problems/valid-anagram/

Topic: Strings, Sorting

Brute Force (Sorting):

1. If lengths are different,
   return false.
2. Convert both strings into character arrays.
3. Sort both arrays.
4. Compare each character.
5. If all characters match,
   return true.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < s.length(); i++) {

            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
/*
LeetCode 242 : Valid Anagram

Question Link:
https://leetcode.com/problems/valid-anagram/

Topic: Strings, HashMap

Optimal (HashMap Frequency Count):

1. If lengths are different,
   return false.
2. Build the frequency map for both strings.
3. Compare both frequency maps.
4. If both maps are equal,
   the strings are anagrams.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    HashMap<Character, Integer> makeFreqMap(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        return map;
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = makeFreqMap(s);
        HashMap<Character, Integer> map2 = makeFreqMap(t);

        return map1.equals(map2);
    }
}
