/*
LeetCode 151 : Reverse Words in a String

Question Link:
https://leetcode.com/problems/reverse-words-in-a-string/

Topic: Strings, Two Pointers

Brute Force (Split + StringBuilder):

1. Remove leading and trailing spaces.
2. Split the string into words.
3. Traverse the words in reverse order.
4. Append each word with a single space.
5. Return the final string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String reverseWords(String s) {

        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            ans.append(words[i]);

            if (i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
/*
LeetCode 151 : Reverse Words in a String

Question Link:
https://leetcode.com/problems/reverse-words-in-a-string/

Topic: Strings, Two Pointers

Optimal (In-Place Simulation):

1. Reverse the entire string.
2. Traverse the reversed string.
3. Skip extra spaces.
4. Copy each word to its correct position.
5. Reverse each copied word.
6. Keep only one space between words.
7. Return the resulting string.

Time Complexity: O(n)
Space Complexity: O(1) (excluding output string)
*/

class Solution {

    void reverse(char[] s, int i, int j) {

        while (i < j) {

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }

    public String reverseWords(String s) {

        char[] str = s.toCharArray();

        int n = str.length;

        // Reverse the whole string
        reverse(str, 0, n - 1);

        int i = 0;
        int l = 0;
        int r = 0;

        while (i < n) {

            // Skip extra spaces
            while (i < n && str[i] == ' ') {
                i++;
            }

            l = r;

            // Copy current word
            while (i < n && str[i] != ' ') {
                str[r] = str[i];
                r++;
                i++;
            }

            // Reverse copied word
            reverse(str, l, r - 1);

            // Skip extra spaces
            while (i < n && str[i] == ' ') {
                i++;
            }

            // Add one space if another word exists
            if (i < n) {
                str[r] = ' ';
                r++;
            }
        }

        return new String(str, 0, r);
    }
}
