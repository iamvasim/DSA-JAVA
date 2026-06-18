/*
LeetCode 1482 : Minimum Number of Days to Make m Bouquets

Question Link:
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

Topic: Binary Search

Optimal (Binary Search on Answer):

1. Find the minimum and maximum bloom day.
2. Search in the range [minDay, maxDay].
3. For a given day, check if at least m bouquets can be formed.
4. If possible, try a smaller day.
5. Otherwise, increase the day.
6. The first valid day is the answer.

Time Complexity: O(n * log(maxDay))
Space Complexity: O(1)
*/

class Solution {

    boolean possible(int[] bloomDay, int m, int k, int day) {

        int count = 0;
        int bouquets = 0;

        for (int flower : bloomDay) {

            if (flower <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int low = minDay;
        int high = maxDay;

        int ans = maxDay;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(bloomDay, m, k, mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}




/*
LeetCode 1482 : Minimum Number of Days to Make m Bouquets

Question Link:
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

Topic: Binary Search

Brute Force:

1. Find the minimum and maximum bloom day.
2. Check every day from minimum to maximum.
3. Count how many bouquets can be formed on that day.
4. Return the first day on which at least m bouquets can be made.

Time Complexity: O((maxDay - minDay + 1) * n)
Space Complexity: O(1)
*/

class Solution {

    boolean possible(int[] bloomDay, int m, int k, int day) {

        int count = 0;
        int bouquets = 0;

        for (int flower : bloomDay) {

            if (flower <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        for (int day = minDay; day <= maxDay; day++) {

            if (possible(bloomDay, m, k, day)) {
                return day;
            }
        }

        return -1;
    }
}
