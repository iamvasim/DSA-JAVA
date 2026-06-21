/*
LeetCode 1539 : Kth Missing Positive Number

Question Link:
https://leetcode.com/problems/kth-missing-positive-number/

Topic: Binary Search

Brute Force:

1. Start from number 1.
2. Traverse positive integers one by one.
3. If the current number is present in the array,
   move to the next array element.
4. Otherwise, it is a missing number.
5. Decrease k for every missing number found.
6. When k becomes 0, return the current number.

Time Complexity: O(answer)
Space Complexity: O(1)
*/

class Solution {

    public int findKthPositive(int[] arr, int k) {

        int num = 1;
        int i = 0;

        while (true) {

            if (i < arr.length && arr[i] == num) {

                i++;

            } else {

                k--;
            }

            if (k == 0) {
                return num;
            }

            num++;
        }
    }
}

/*
LeetCode 1539 : Kth Missing Positive Number

Question Link:
https://leetcode.com/problems/kth-missing-positive-number/

Topic: Binary Search

Optimal (Binary Search):

Missing numbers before arr[i]:

missing = arr[i] - (i + 1)

1. Find the first index where missing >= k.
2. The answer lies before that index.
3. Return low + k.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return low + k;
    }
}
