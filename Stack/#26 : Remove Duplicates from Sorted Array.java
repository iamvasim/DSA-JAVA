/*
LeetCode 26 : Remove Duplicates from Sorted Array

Question Link:
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Topic: Arrays, Stack

Brute Force (Stack):

1. Traverse the array from right to left.
2. Push only unique elements into the stack.
3. Pop elements from the stack back into the array.
4. The first k positions contain the unique elements.
5. Return the number of unique elements.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        // Store unique elements
        for (int i = n - 1; i >= 0; i--) {

            if (st.isEmpty() || st.peek() != nums[i]) {
                st.push(nums[i]);
            }
        }

        int i = 0;
        int count = 0;

        // Copy back to the array
        while (!st.isEmpty()) {

            nums[i] = st.pop();
            count++;
            i++;
        }

        return count;
    }
}/*
LeetCode 26 : Remove Duplicates from Sorted Array

Question Link:
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Topic: Arrays, Two Pointers

Optimal (Two Pointers):

1. Maintain two pointers:
      - i: points to the last unique element.
      - j: scans the array.
2. Traverse the array using j.
3. Whenever nums[j] is different from nums[i]:
      - Increment i.
      - Copy nums[j] to nums[i].
4. After traversal, the first (i + 1) elements
   contain all unique values.
5. Return (i + 1).

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[i] != nums[j]) {

                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
