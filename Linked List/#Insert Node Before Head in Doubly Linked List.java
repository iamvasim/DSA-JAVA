/*
Insert Node Before Head in Doubly Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/insert-node-before-head-in-doubly-linked-list

Topic: Doubly Linked List

Optimal:

1. Create a new node with the given value.
2. Point newNode.next to the current head.
3. Point head.prev to the new node.
4. Make newNode the new head.
5. Return the updated head.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public ListNode insertBeforeHead(ListNode head, int data) {

        ListNode newNode = new ListNode(data);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;

        head.prev = newNode;

        return newNode;
    }
}
