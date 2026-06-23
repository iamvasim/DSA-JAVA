/*
LeetCode 237 : Delete Node in a Linked List

Question Link:
https://leetcode.com/problems/delete-node-in-a-linked-list/

Topic: Linked List

Optimal:

1. Copy the value of the next node into the current node.
2. Skip the next node by updating the next pointer.
3. The current node now effectively becomes the next node.
4. The original next node is removed from the list.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }
}
