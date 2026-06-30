/*
TUF : Add One to a Number Represented by Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/add-one-to-a-number-represented-by-linked-list

Topic: Linked List

Optimal (Reverse Linked List):

1. Reverse the linked list.
2. Initialize carry = 1 (to add one).
3. Traverse the reversed list:
      - Add carry to current digit.
      - Store sum % 10 in current node.
      - Update carry = sum / 10.
      - Stop early if carry becomes 0.
4. If carry still remains after the last node,
   append a new node with value 1.
5. Reverse the linked list again.
6. Return the new head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    // Reverse a singly linked list
    ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addOne(ListNode head) {

        // Reverse the linked list
        head = reverse(head);

        int carry = 1;

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            int sum = temp.val + carry;

            temp.val = sum % 10;
            carry = sum / 10;

            prev = temp;
            temp = temp.next;

            // No carry left, stop processing
            if (carry == 0) {
                break;
            }
        }

        // If carry remains, append a new node
        if (carry == 1) {
            prev.next = new ListNode(1);
        }

        // Reverse again to restore original order
        head = reverse(head);

        return head;
    }
}
