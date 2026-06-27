/*
LeetCode 328 : Odd Even Linked List

Question Link:
https://leetcode.com/problems/odd-even-linked-list/

Topic: Linked List

Optimal:

1. If the linked list is empty,
   return the head.
2. Keep two pointers:
      odd  -> first node
      even -> second node.
3. Store the head of the even list.
4. Connect all odd indexed nodes together.
5. Connect all even indexed nodes together.
6. Attach the even list after the odd list.
7. Return the head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
