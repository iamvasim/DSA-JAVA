/*
Insertion at the Head of Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/insertion-at-the-head-of-linked-list

Topic: Linked List

Optimal:

1. Create a new node with value X.
2. Point the new node's next to the current head.
3. Make the new node the new head.
4. Return the updated head.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public ListNode insertAtHead(ListNode head, int X) {

        ListNode newNode = new ListNode(X);

        newNode.next = head;

        head = newNode;

        return head;
    }
}
