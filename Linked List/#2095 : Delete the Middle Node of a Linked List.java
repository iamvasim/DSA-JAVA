/*
LeetCode 2095 : Delete the Middle Node of a Linked List

Question Link:
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Topic: Linked List

Brute Force:

1. Find the length of the linked list.
2. If the list has only one node,
   return null.
3. Calculate the middle index as length / 2.
4. Traverse to the node just before the middle node.
5. Delete the middle node.
6. Return the head.

Time Complexity: O(2n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        int length = 0;

        ListNode temp = head;

        while (temp != null) {

            length++;

            temp = temp.next;
        }

        int middle = length / 2;

        temp = head;

        for (int i = 1; i < middle; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}

/*
LeetCode 2095 : Delete the Middle Node of a Linked List

Question Link:
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Topic: Linked List

Optimal (Slow & Fast Pointer):

1. If the list has only one node,
   return null.
2. Initialize three pointers:
      prev = null
      slow = head
      fast = head
3. Move slow by one step and fast by two steps.
4. Keep track of the previous node of slow.
5. When fast reaches the end,
   slow will be at the middle node.
6. Delete the middle node.
7. Return the head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            prev = slow;

            slow = slow.next;

            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
