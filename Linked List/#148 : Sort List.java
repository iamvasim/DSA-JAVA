/*
LeetCode 148 : Sort List

Question Link:
https://leetcode.com/problems/sort-list/

Topic: Linked List

Brute Force:

1. Traverse the linked list and store all node values
   in an ArrayList.
2. Sort the ArrayList.
3. Create a new linked list using the sorted values.
4. Return the head of the new linked list.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);

            temp = temp.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;

        for (int value : list) {

            curr.next = new ListNode(value);

            curr = curr.next;
        }

        return dummy.next;
    }
}/*
LeetCode 148 : Sort List

Question Link:
https://leetcode.com/problems/sort-list/

Topic: Linked List

Optimal (Merge Sort):

1. If the list has zero or one node,
   it is already sorted.
2. Find the middle node using Slow and Fast pointers.
3. Split the linked list into two halves.
4. Recursively sort both halves.
5. Merge the two sorted linked lists.
6. Return the merged list.

Time Complexity: O(n log n)
Space Complexity: O(log n)
(Recursion Stack)
*/

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        ListNode head2 = slow.next;

        slow.next = null;

        head = sortList(head);

        head2 = sortList(head2);

        return merge(head, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val <= head2.val) {

                tail.next = head1;

                head1 = head1.next;
            }
            else {

                tail.next = head2;

                head2 = head2.next;
            }

            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        }
        else {
            tail.next = head2;
        }

        return dummy.next;
    }
}
