/*
LeetCode 682 : Baseball Game

Question Link:
https://leetcode.com/problems/baseball-game/

Topic: Stack

Optimal (Stack):

1. Traverse each operation in the given array.
2. If the operation is:
      - Integer:
          Push it onto the stack.
      - "C":
          Remove the last valid score.
      - "D":
          Push double of the last valid score.
      - "+":
          Push the sum of the last two valid scores.
3. After processing all operations,
   add all values remaining in the stack.
4. Return the total score.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {

    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        // Process every operation
        for (String op : operations) {

            // Remove previous score
            if (op.equals("C")) {

                st.pop();

            }

            // Double previous score
            else if (op.equals("D")) {

                st.push(2 * st.peek());

            }

            // Sum of previous two scores
            else if (op.equals("+")) {

                int last = st.pop();
                int sum = last + st.peek();

                st.push(last);
                st.push(sum);

            }

            // Integer score
            else {

                st.push(Integer.parseInt(op));
            }
        }

        // Calculate final score
        int total = 0;

        for (int score : st) {
            total += score;
        }

        return total;
    }
}
