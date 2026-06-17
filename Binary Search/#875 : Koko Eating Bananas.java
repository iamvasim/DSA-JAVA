/*
LeetCode 875 : Koko Eating Bananas

Question Link:
https://leetcode.com/problems/koko-eating-bananas/

Topic: Binary Search

Optimal (Binary Search on Answer):

1. Minimum eating speed can be 1.
2. Maximum eating speed can be the largest pile.
3. For a given speed k, calculate the total hours required.
4. If hours <= h, try a smaller speed.
5. Otherwise, increase the speed.
6. The first valid speed is the answer.

Time Complexity: O(n * log(maxPile))
Space Complexity: O(1)
*/

class Solution {

    long requiredHours(int[] piles, int speed) {

        long hours = 0;

        for (int bananas : piles) {

            hours += bananas / speed;

            if (bananas % speed != 0) {
                hours++;
            }
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;

        int high = 1;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = requiredHours(piles, mid);

            if (hours <= h) {

                ans = mid;

                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}
