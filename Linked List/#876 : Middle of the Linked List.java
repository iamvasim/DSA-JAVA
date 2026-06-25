/*
LeetCode 876 : Middle of the Linked List

Question Link:
https://leetcode.com/problems/middle-of-the-linked-list/

Topic: Linked List

Brute Force:

1. Traverse the linked list to find its length.
2. Traverse again up to length / 2.
3. Return that node.
4. If there are two middle nodes,
   return the second middle node.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode middleNode(ListNode head) {

        int length = 0;

        ListNode temp = head;

        while (temp != null) {

            length++;

            temp = temp.next;
        }

        temp = head;

        for (int i = 0; i < length / 2; i++) {

            temp = temp.next;
        }

        return temp;
    }
}

/*
LeetCode 876 : Middle of the Linked List

Question Link:
https://leetcode.com/problems/middle-of-the-linked-list/

Topic: Linked List

Optimal (Slow & Fast Pointer):

1. Initialize two pointers:
      slow = head
      fast = head
2. Move slow by one node.
3. Move fast by two nodes.
4. When fast reaches the end,
   slow will be at the middle node.
5. Return slow.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }
}
