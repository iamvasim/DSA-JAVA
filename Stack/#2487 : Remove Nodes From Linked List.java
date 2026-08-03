/*
LeetCode 2487 : Remove Nodes From Linked List

Question Link:
https://leetcode.com/problems/remove-nodes-from-linked-list/

Topic: Linked List, Stack

Approach (Monotonic Stack):

1. Traverse the linked list from left to right.
2. Maintain a monotonic decreasing stack.
3. For every node:
      - Remove all smaller values from the top
        of the stack because they have a greater
        value on their right.
      - Push the current value onto the stack.
4. After traversal, the stack contains only the
   values that should remain.
5. Reconstruct the linked list by popping the
   stack and inserting nodes at the front.
6. Return the head of the new linked list.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public ListNode removeNodes(ListNode head) {

        Stack<Integer> st = new Stack<>();

        ListNode temp = head;

        // Build a monotonic decreasing stack
        while (temp != null) {

            while (!st.isEmpty() && st.peek() < temp.val) {
                st.pop();
            }

            st.push(temp.val);

            temp = temp.next;
        }

        // Reconstruct the linked list
        ListNode newHead = null;

        while (!st.isEmpty()) {

            ListNode node = new ListNode(st.pop());

            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }
}
