/*
LeetCode 206 : Reverse Linked List

Question Link:
https://leetcode.com/problems/reverse-linked-list/

Topic: Linked List

Optimal (Iterative):

1. Initialize three pointers:
      prev = null
      curr = head
      next = null
2. Store the next node.
3. Reverse the current node's next pointer.
4. Move prev and curr one step forward.
5. Continue until curr becomes null.
6. Return prev as the new head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }
}


/*
LeetCode 206 : Reverse Linked List

Question Link:
https://leetcode.com/problems/reverse-linked-list/

Topic: Linked List

Optimal (Recursive):

1. If the list is empty or has one node,
   return the head.
2. Recursively reverse the remaining list.
3. Make the next node point to the current node.
4. Set current node's next to null.
5. Return the new head.

Time Complexity: O(n)
Space Complexity: O(n)
(Recursion Stack)
*/

class Solution {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return newHead;
    }
}
