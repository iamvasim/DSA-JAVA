/*
LeetCode 1011 : Capacity To Ship Packages Within D Days

Question Link:
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

Topic: Binary Search

Brute Force:

1. Minimum capacity must be the maximum package weight.
2. Maximum capacity can be the sum of all weights.
3. Try every capacity from maxWeight to totalWeight.
4. Calculate the number of days required.
5. Return the first capacity that ships all packages within given days.

Time Complexity: O((sum(weights) - max(weights)) * n)
Space Complexity: O(1)
*/

class Solution {

    int findDays(int[] weights, int capacity) {

        int load = 0;
        int days = 1;

        for (int weight : weights) {

            if (load + weight > capacity) {

                days++;
                load = weight;

            } else {

                load += weight;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int maxWeight = 0;
        int totalWeight = 0;

        for (int weight : weights) {

            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        for (int capacity = maxWeight;
             capacity <= totalWeight;
             capacity++) {

            if (findDays(weights, capacity) <= days) {
                return capacity;
            }
        }

        return -1;
    }
}



/*
LeetCode 1011 : Capacity To Ship Packages Within D Days

Question Link:
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

Topic: Binary Search

Optimal (Binary Search on Answer):

1. Minimum capacity = maximum package weight.
2. Maximum capacity = sum of all weights.
3. For a given capacity, calculate days required.
4. If days <= required days,
   try a smaller capacity.
5. Otherwise, increase capacity.
6. The first valid capacity is the answer.

Time Complexity: O(n * log(sum(weights)))
Space Complexity: O(1)
*/

class Solution {

    int findDays(int[] weights, int capacity) {

        int load = 0;
        int days = 1;

        for (int weight : weights) {

            if (load + weight > capacity) {

                days++;
                load = weight;

            } else {

                load += weight;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int maxWeight = 0;
        int totalWeight = 0;

        for (int weight : weights) {

            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int low = maxWeight;
        int high = totalWeight;

        int ans = totalWeight;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (findDays(weights, mid) <= days) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }  
}
