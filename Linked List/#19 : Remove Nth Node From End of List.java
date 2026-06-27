/*
LeetCode 19 : Remove Nth Node From End of List

Question Link:
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Topic: Linked List

Brute Force:

1. Traverse the linked list to find its length.
2. If the node to remove is the head,
   return head.next.
3. Traverse again to reach the node
   just before the target node.
4. Remove the target node.
5. Return the head.

Time Complexity: O(2n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;

        int length = 0;

        while (temp != null) {

            length++;

            temp = temp.next;
        }

        if (length == n) {
            return head.next;
        }

        temp = head;

        int i = 1;

        while (i < length - n) {

            temp = temp.next;

            i++;
        }

        temp.next = temp.next.next;

        return head;
    }
}

/*
LeetCode 19 : Remove Nth Node From End of List

Question Link:
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Topic: Linked List

Optimal (One Pass - Two Pointers):

1. Initialize two pointers:
      slow = head
      fast = head
2. Move the fast pointer n steps ahead.
3. If fast becomes null,
   remove the head node.
4. Move both pointers one step at a time
   until fast reaches the end.
5. Slow will point to the node to be deleted
   and prev will point to the previous node.
6. Remove the target node.
7. Return the head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Remove head node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers together
        while (fast != null) {

            prev = slow;

            slow = slow.next;

            fast = fast.next;
        }

        // Delete the target node
        prev.next = slow.next;

        return head;
    }
}
