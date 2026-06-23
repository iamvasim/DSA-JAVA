/*
Find the Length of the Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/find-the-length-of-the-linked-list

Topic: Linked List

Optimal:

1. Initialize length = 0.
2. Traverse the linked list from head.
3. Increment length for every node visited.
4. Return the final length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int getLength(ListNode head) {

        int length = 0;

        ListNode temp = head;

        while (temp != null) {

            length++;

            temp = temp.next;
        }

        return length;
    }
}
