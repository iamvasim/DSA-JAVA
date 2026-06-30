/*
LeetCode 21 : Merge Two Sorted Lists

Question Link:
https://leetcode.com/problems/merge-two-sorted-lists/

Topic: Linked List

Optimal:

1. Handle edge cases:
      - If list1 is null, return list2.
      - If list2 is null, return list1.
2. Create a dummy node to build the merged list.
3. Compare the current nodes of both lists.
4. Attach the smaller node to the merged list.
5. Move the pointer of the selected list.
6. Repeat until one list becomes empty.
7. Attach the remaining nodes of the other list.
8. Return dummy.next.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode i = list1;
        ListNode j = list2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (i != null && j != null) {

            if (i.val <= j.val) {
                temp.next = i;
                i = i.next;
            }
            else {
                temp.next = j;
                j = j.next;
            }

            temp = temp.next;
        }

        if (i == null) {
            temp.next = j;
        }
        else {
            temp.next = i;
        }

        return dummy.next;
    }
}
