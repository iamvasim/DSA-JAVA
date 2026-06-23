/*
Delete Head of Doubly Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/delete-head-of-doubly-linked-list

Topic: Doubly Linked List

Optimal:

1. If the list is empty, return null.
2. If only one node exists, return null.
3. Move head to the second node.
4. Set head.prev to null.
5. Return the updated head.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public ListNode deleteHead(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;

        head.prev = null;

        return head;
    }
}
