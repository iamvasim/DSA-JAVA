/*
Find Square Root of a Number

Question Link:
https://takeuforward.org/plus/dsa/problems/find-square-root-of-a-number

Topic: Binary Search

Optimal (Binary Search):

1. Search in the range [0, n].
2. If mid * mid <= n, store mid as a possible answer.
3. Search on the right to find a larger valid value.
4. Otherwise, search on the left.
5. The final answer will be the floor value of sqrt(n).

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int floorSqrt(int n) {

        int ans = 0;

        int low = 0;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid <= (n / mid)) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return ans;
    }
}
