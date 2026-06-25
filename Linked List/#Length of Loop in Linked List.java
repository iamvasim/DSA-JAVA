/*
Length of Loop in Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/length-of-loop-in-linked-list

Topic: Linked List

Optimal (Floyd's Cycle Detection):

1. Use Slow and Fast pointers to detect a cycle.
2. If no cycle exists, return 0.
3. When slow and fast meet, keep one pointer fixed.
4. Move another pointer around the cycle until it reaches
   the meeting node again while counting the nodes.
5. Return the count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findLengthOfLoop(ListNode head) {

        if (head == null || head.next == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                int length = 1;

                ListNode temp = slow.next;

                while (temp != slow) {

                    length++;

                    temp = temp.next;
                }

                return length;
            }
        }

        return 0;
    }
}
