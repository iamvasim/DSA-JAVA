/*
LeetCode 2 : Add Two Numbers

Question Link:
https://leetcode.com/problems/add-two-numbers/

Topic: Linked List

Optimal:

1. Create a dummy node to build the answer list.
2. Traverse both linked lists simultaneously.
3. At each step:
      - Add values from both lists (if present).
      - Add the carry from the previous step.
4. Create a new node with (sum % 10).
5. Update carry = sum / 10.
6. Move to the next nodes of both lists.
7. After traversal, if carry remains,
   append one final node.
8. Return dummy.next.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
*/

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;

        while (temp1 != null || temp2 != null) {

            int sum = carry;

            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        // If carry remains after processing both lists
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
