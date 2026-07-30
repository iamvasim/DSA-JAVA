/*
GFG : First Negative in Windows of Size K

Question Link:
https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

Topic: Arrays, Sliding Window, Queue

Optimal (Sliding Window + Queue):

1. Traverse the array and store the indices of
   all negative elements in a queue.
2. For each window:
      - Remove indices from the front of the queue
        that are outside the current window.
3. If the front of the queue lies inside the current
   window, it is the first negative element.
4. Otherwise, append 0.
5. Repeat for every window and return the result.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    static List<Integer> firstNegInt(int arr[], int k) {

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int n = arr.length;

        // Store indices of all negative elements
        for (int i = 0; i < n; i++) {

            if (arr[i] < 0) {
                q.add(i);
            }
        }

        // Process each window
        for (int i = 0; i <= n - k; i++) {

            // Remove indices that are outside the current window
            if (!q.isEmpty() && q.peek() < i) {
                q.remove();
            }

            // First negative element in the current window
            if (!q.isEmpty() && q.peek() <= i + k - 1) {
                ans.add(arr[q.peek()]);
            } else {
                ans.add(0);
            }
        }

        return ans;
    }
}
