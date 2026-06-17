/*
Find Nth Root of a Number

Question Link:
https://takeuforward.org/plus/dsa/problems/find-nth-root-of-a-number

Topic: Binary Search

Optimal (Binary Search):

1. Search in the range [1, M].
2. Calculate mid^N.
3. If mid^N == M, return mid.
4. If mid^N < M, search on the right.
5. Otherwise, search on the left.
6. If no integer Nth root exists, return -1.

Time Complexity: O(N * log M)
Space Complexity: O(1)
*/

class Solution {

    long findRoot(int mid, int n, int m) {

        long ans = 1;

        for (int i = 0; i < n; i++) {

            ans *= mid;

            if (ans > m) {
                return ans;
            }
        }

        return ans;
    }

    public int NthRoot(int N, int M) {

        int low = 1;
        int high = M;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long value = findRoot(mid, N, M);

            if (value == M) {
                return mid;
            }

            if (value < M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
