/*
Reverse a Doubly Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/reverse-a-doubly-linked-list

Topic: Doubly Linked List

Brute Force:

1. Store all node values in a stack.
2. Traverse the list again.
3. Replace each node's value with the top element of the stack.
4. Return the head.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public ListNode reverseDLL(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;

        while (temp != null) {

            stack.push(temp.data);

            temp = temp.next;
        }

        temp = head;

        while (temp != null) {

            temp.data = stack.pop();

            temp = temp.next;
        }

        return head;
    }
}

/*
Reverse a Doubly Linked List

Question Link:
https://takeuforward.org/plus/dsa/problems/reverse-a-doubly-linked-list

Topic: Doubly Linked List

Optimal:

1. Traverse the doubly linked list.
2. For every node, swap prev and next pointers.
3. Move to the original next node
   (which becomes prev after swapping).
4. The last processed node becomes the new head.
5. Return the new head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode reverseDLL(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode newHead = null;

        while (current != null) {

            ListNode temp = current.prev;

            current.prev = current.next;

            current.next = temp;

            newHead = current;

            current = current.prev;
        }

        return newHead;
    }
}
