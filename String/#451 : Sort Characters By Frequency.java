/*
LeetCode 451 : Sort Characters By Frequency

Question Link:
https://leetcode.com/problems/sort-characters-by-frequency/

Topic: Strings, HashMap, Sorting

Optimal (HashMap + Sorting):

1. Traverse the string and store the frequency
   of each character in a HashMap.
2. Convert the HashMap entries into a list.
3. Sort the list in descending order of frequency.
4. Traverse the sorted list and append each
   character according to its frequency.
5. Return the constructed string.

Time Complexity: O(n + k log k)
where k = number of distinct characters.

Space Complexity: O(k)
*/

class Solution {

    public String frequencySort(String s) {

        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        // Convert map into list
        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Sort by frequency in descending order
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        StringBuilder ans = new StringBuilder();

        // Build the answer
        for (Map.Entry<Character, Integer> entry : list) {

            char ch = entry.getKey();
            int freq = entry.getValue();

            while (freq > 0) {
                ans.append(ch);
                freq--;
            }
        }

        return ans.toString();
    }
}
