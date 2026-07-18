/*
LeetCode 387 : First Unique Character in a String

Question Link:
https://leetcode.com/problems/first-unique-character-in-a-string/

Topic: Strings, HashMap

Brute Force (HashMap):

1. Traverse the string and store the frequency
   of every character in a HashMap.
2. Traverse the string again.
3. Return the index of the first character
   whose frequency is 1.
4. If no such character exists,
   return -1.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int firstUniqChar(String s) {

        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (map.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}/*
LeetCode 387 : First Unique Character in a String

Question Link:
https://leetcode.com/problems/first-unique-character-in-a-string/

Topic: Strings, Arrays

Optimal (Frequency Array):

1. Create a frequency array of size 26.
2. Count the frequency of each character.
3. Traverse the string again.
4. Return the index of the first character
   whose frequency is 1.
5. If no such character exists,
   return -1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            freq[ch - 'a']++;
        }

        // Find first unique character
        for (int i = 0; i < s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
